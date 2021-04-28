<template>
  <div class="productContent">
    <div class="sortListArea">
      <div class="total">
        총
        <span id="total-span">{{productTotal.totalCount}}</span>
        개
      </div>
        <div class="boardCheckList">
          <ul>
            <li>
              <input name="check" id="01" type="radio" v-model="radioValues"  value="01" checked />
              <label for="01">판매량순</label>
            </li>
            <li selected="selected">
              <input name="check" id="02" type="radio" v-model="radioValues"  value="02" />
              <label for="02">최근등록순</label>
            </li>
            <li selected="selected">
              <input name="check" id="03" type="radio" v-model="radioValues"  value="03" />
              <label for="03">낮은가격순</label>
            </li>
            <li selected="selected">
              <input name="check" id="04" type="radio" v-model="radioValues"  value="04" />
              <label for="04">높은가격순</label>
            </li>
          </ul>
        </div>
    </div>
    <v-container class="prd-main">
      <v-row no-gutters>
        <v-col 
        @click="cartReBtn(product)"
        v-for="(product, idx) in productLists" :key="idx" >
          <v-card max-hight="400" max-width="350">
            <v-img class="card-img" :src="product.imgFullUrl">
            </v-img>

            <v-card-title>
              <strong> 상품명 : {{ product.brdNm }}</strong>
            </v-card-title>

            <v-card-text>
              <v-row align="center" class="mx-0"> </v-row>
              <div class="prd-coment">내용 : {{ product.spdNm }}</div>

              <div>
                <strong>가격 : {{ product.slPrc }} </strong>
                <v-rating :value="4.5" color="yellow" dense half-increments readonly size="20" class="star"></v-rating>
              <strong>4.5 (413)</strong>
              </div>
            </v-card-text>
          </v-card>
        </v-col >
      </v-row>
      <div class="text-center">
    <v-pagination
      v-model="page"
      :length="6"
    ></v-pagination>
  </div>
    </v-container>
     
  </div>
</template>

<script>
import axios from "axios";
import Cart from "../model/Cart"
import {CartApi} from "../api"

export default {
  name: "prdList",
  data() {
    return {
      productLists: [],
      productTotal:[],
      radioValues: '01',
      page: '',
      cart: new Cart(),
      prdInfo: []
      
    }
  },
  created: async function () {
    const BASE_URL =
      "https://www.lotteon.com/p/display/category/seltCatePdWishListAjax?pdSortCd=01&pageNo=1&rowsPerPage=60&dshopNo=22276";
    await axios.get(BASE_URL).then((e) => {
      this.productLists = e.data.catePdList.dataList;
      this.productTotal = e.data.catePdList;
    })
  },
  watch:{
   
    '$route.params': 'changeUrl',
    'radioValues': 'fetchData',
    'page': 'fetchPage'
  },
  methods: {
    async changeUrl() {
    const fetchUrl =
    "https://www.lotteon.com/p/display/category/seltCatePdWishListAjax?pdSortCd=01&pageNo=1&rowsPerPage=60&dshopNo=" + this.$route.params.dshopNo + "";
    await axios.get(fetchUrl).then((r) => {
       this.productLists = r.data.catePdList.dataList;
       this.productTotal = r.data.catePdList;
       
     })
      },
    async fetchData(){
      const radioData =
      "https://www.lotteon.com/p/display/category/seltCatePdWishListAjax?pdSortCd="+ this.radioValues +"&pageNo="+ this.page +"&rowsPerPage=60&dshopNo=" + this.$route.params.dshopNo + "";
      await axios.get(radioData).then((r) => {
       this.productLists = r.data.catePdList.dataList;
       this.productTotal = r.data.catePdList;
      })
    },
    async fetchPage(){
       const pageData =
      "https://www.lotteon.com/p/display/category/seltCatePdWishListAjax?pdSortCd="+ this.radioValues +"&pageNo="+ this.page +"&rowsPerPage=60&dshopNo=" + this.$route.params.dshopNo + "";
      await axios.get(pageData).then((r) => {
       this.productLists = r.data.catePdList.dataList;
       this.productTotal = r.data.catePdList;

      })
    },
     cartReBtn: async function(product){
      //  배열 형식의 데이터에 객체 보냄
       let parms =[
         {
             spdNo: product.spdNo, sitmNo: product.sitmNo
         }
       ]
      const cartInfoUrl = 
      "https://pbf.lotteon.com/product/v1/detail/productDetailList?dataType=LIGHT2"
      await axios.post(cartInfoUrl, parms).then((r) =>{
      
      this.cart.spdNo = r.data.data[0].spdNo;
      this.cart.sitmNo = r.data.data[0].sitmNo;
      this.cart.trNo = r.data.data[0].trNo;
      this.cart.lrtrNo = r.data.data[0].lrtrNo;
      this.cart.returnCode = r.data.data[0].returnCode;
      
      console.log(this.cart.spdNo)
        console.log(this.cart.sitmNo)
        console.log(this.cart.trNo)
        console.log(this.cart.lrtrNo)
      
      }).catch(error =>{
        console.log(error.message);
      })

      if(this.cart.returnCode == 200 &&  this.cart.lrtrNo != null){
        alert("💘장바구니에 등록되었습니다.💘")
      }else{
        alert("❌장바구니에 등록되지않았습니다.❌")
      }
      // 콘솔 server 통신 log
      CartApi.register(this.cart).then(value => console.log(value))
      
    }
   }
}
   
</script>
<style scoped>
.prd-coment {
  display: -webkit-box;
  line-height: 23px;
  -webkit-line-clamp: 1;
  -webkit-box-orient: vertical;
  overflow: hidden;
}
.sortListArea{
  height: 40px;
    padding: 12px 0;
    margin: 18px 0 20px;
    border-bottom: 1px solid #eee;
    -webkit-box-sizing: content-box;
    box-sizing: content-box;
}
.total {
  float: left;
  vertical-align: middle;
  font-size: 13px;
  line-height: 40px;
  letter-spacing: -0.02em;
  color: #757575;
  margin-left: 80px;
}
#total-span {
  font-size: 20px;
  
  color: #000;
}
.total{
  margin-left: 400px;
}

.boardCheckList {
  float: right;
  margin-right: 450px;
  padding: 0;
  border: 0;
}
li{
    margin-right: 100px;
    position: relative;
    display: inline-block;
    line-height: 40px;
}
.card-img{
  width: 350px;
  height: 350px;
  object-fit: cover;
}
li{
  margin-right: 15px;
  position: relative;
}
.container.container.prd-main{
  max-width: 1700px;
}
</style>
