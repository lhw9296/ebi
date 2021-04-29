<template>
<div>
  <!-- <li v-for="(ListData, idx) in CartLists" :key="idx" class="productComponent-li"> -->
    <li v-if="cartLists">
    <div class="cartProduct">
      <input type="checkbox">
      <button
    type="button"
    class="deleteItem" @click="deleteCart(cartLists)"/>
      <div class="productItem">
      <div class="productThumb">
        <a>
          <v-img
          :src="cartLists.imgJsn[0].origImgFileNm"
          />
        </a>
      </div>
      <div class="productData">
        <p class="productContent"><strong>{{cartLists.brdNm}} </strong> {{cartLists.spdNm}}</p>
        <p class="productDeliveryInfo">{{cartLists.estmtDlvTxt}}</p>
      </div>
      <div class="cartQty">
      <!-- plus, mius 관련 버튼 -->
      <button id="minusBtn" class="minus" @click="minOdQty" /> 
      <div class="number">
        <input type="number"  id="numberV" :value="cartLists.odQty"  >
        <label for="numberV" class="blind"></label>
      </div>
      <button class="plus" @click="pluOdQty"/>
    </div>
    <div class="cartPrice">
      <p>
        <strong>{{totalPrice}}</strong>
      </p>
    </div>
      </div>
      <div class="cartFooter">
    </div>
    </div>
  </li>
</div>
</template>

<script>
import CartListInfoDto from "../model/CartListInfoDto"
import debounce from "loadsh"
import EventBus from '../utils/EventBus'
import {CartApi} from '../api'

export default {   
    name: "CartProductComponent",
    props:{
      cartLists : new CartListInfoDto()
    },
    created(){
      this.totalPrice = this.cartLists.odQty*this.cartLists.slPrc
      
    },
    data: function(){
        return {
          totalPrice: 0,
        }
    },
    methods:{
      // 제품 구매 수량 갯수 +, - 기능
      pluOdQty: function(){
        const price = this.cartLists.slPrc*1;
        let target = document.getElementById('minusBtn');
        this.cartLists.odQty++; 
        this.totalPrice += price;
        EventBus.$emit("groupPluTotal", price);
        this.debounceCart();

        if(this.cartLists.odQty > 1){
          target.disabled = false;
        }
      },
      minOdQty: function(){
         const price = this.cartLists.slPrc*1;
         let target = document.getElementById('minusBtn');
         this.cartLists.odQty--;
         this.totalPrice -= price;
         EventBus.$emit("groupMiuTotal", price);
          this.debounceCart();
         if(this.cartLists.odQty == 1 ){
          alert("❌1개이상 수량을 선택하세요")
          target.disabled = true;
         }
      },
      // 각 카트등록 상품 삭제 기능
    deleteCart: function(cartLists){
      let spdNo = cartLists.spdNo
      console.log(spdNo)
        CartApi.remove(spdNo).then(r => console.log("cartProductComponent",r))
         alert("✅삭제 되었습니다.")
        this.$router.go();
  },
    // debounce 기능구현
  debounceCart: debounce.debounce(function(){
      EventBus.$emit('modifyCart', this.cartLists);
    }, 500),
    }
}
</script>

<style>
.productComponent-li{
  border: 1px  black ;
}
.cartProduct{
  margin-top: 0px;
  margin-left: 300px;
  width: 700px;
  position: relative;
  padding-right: 56px;
  border: 1px solid #ddd;
  
}
.productItem {
    padding-left: 28px;
    display: flex;
    width: 385px;
  }
  
  .productItem .productThumb {
    width: 100px;
    min-width: 100px;
    height: 80px;
    margin-right: 25px;
    
  }
  .productThumb a {
    background: #e5e5e5;
    width: 80px;
    height: 80px;
  }
  .productThumb a .v-image {
    border-radius: 6px;
  }
 
  .productData .productContent{
    width: 200px;
    position: relative;
  }
  
  .productItem .productData .productDeliveryInfo {
    margin-top: 6px;
    font-size: 14px;
    line-height: 1.57;
    color: #4185ed;
  }
  .cartQty {
    min-width: 100px;
    display: flex;
    border: 1px solid #ddd;
    border-radius: 6px;
    width: 100px;
    height: 32px;
    margin: 0 20px;
    margin-top: 30px;
    margin-left: 50px;
  }
  .cartQty .minus {
    overflow: hidden;
    width: 100px;
    height: 30px;
    background: url('//static.lotteon.com/p/order/assets/img/btn_minus.svg') no-repeat 50%;
  }
  .cartQty .plus {
    overflow: hidden;
    width: 100px;
    height: 30px;
    background: url('//static.lotteon.com/p/order/assets/img/btn_plus.svg') no-repeat 50%;
  }
  .cartQty .number input {
    padding: 0;
    width: 100%;
    line-height: 30px;
    border: 0;
    text-align: center;
  }
  .cartQty .number {
    border-left: 1px solid #ddd;
    border-right: 1px solid #ddd;
  }
  input::-webkit-outer-spin-button,
  input::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
  }
  .cartPrice{
    margin-top: 35px;
    margin-left: 20px;
  }
  .cartFooter{
    display: flex;
    height: 48px;
    padding: 0 348px;
    font-size: 13px;
    line-height: 48px;
    margin-right: 300px;
    margin-top: 30px;
    letter-spacing: .2px;
    color: #757575;
    border-top: 1px solid #eee;
    background-color: #fef5f4;
    -webkit-box-pack: justify;
    -ms-flex-pack: justify;
    justify-content: space-between;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
  }
  .deleteItem{
    margin-left: 650px;
    margin-top: 10px;
    width: 22px;
    min-width: 22px;
    height: 22px;
    background-repeat: no-repeat;
    background-position: 50%;
    background-size: 100% 100%;
    background-image: url(//static.lotteon.com/p/order/assets/img/icon_delete-item_new.svg);
    border: 1px solid #ddd;
}
 
</style>


