<template>
    <div>
        <div  class="cat-block">
           <h1>Category</h1>
            <ul class="catList">
                <button @click="clickList_1">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22276/PF6293D4093EFDF4F3F6FB6550350FE1E41EE8C9EC1DED58A3C784DF16490F48F/file">
                    </span>
                    <div>
                        <span> 스킨케어</span>
                    </div>
                    <router-link :to="{name: 'prdList', params:{dshopNo: '22276'}}"></router-link>
                </button>
                <button @click="clickList_2">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22279/PDEC5B6822486CB8A5A5D29194A3515F89F1BD71CF38DCBC24E9A19FE7F14AF89/file">
                    </span>
                    <div>
                        <span> 베이스메이크업 </span>
                    </div>
                    <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22279'}}"></router-link>
                </button>
                <button @click="clickList_3">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22280/P41A356C8680A3D4CB1825B5AC1AD82BFF37203BFBE3F9935A0212E899211851E/file">
                    </span>
                    <div>
                        <span> 색조메이크업 </span>
                    </div>
                    <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22280'}}"></router-link>
                </button>
                <button @click="clickList_4">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22282/PF99455EE030503AAEC3D0794F5BDF4A4243E94AA36B339521AE7D290299449E5/file">
                    </span>
                    <div>
                        <span> 썬케어</span>
                    </div>
                      <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22282'}}"></router-link>
                </button>
                <button @click="clickList_5">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22284/P702F709F33906D4249E62CAECCB7717B0A5EE20E1AC60EFBD826E434A4D4CF4D/file">
                    </span>
                    <div>
                        <span> 바디케어</span>
                    </div>
                      <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22284'}}"></router-link>
                </button>
                <button @click="clickList_6">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22286/P405530B15223D89A4C037BA527822C4AB842D69AE26A86E5C70C1BE71C7C7AA1/file">
                    </span>
                    <div>
                        <span> 헤어케어</span>
                    </div>
                      <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22286'}}"></router-link>
                </button>
                <button @click="clickList_7">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22296/P3F3DC68024FC027AC0FF7629D4095D0B581155CEC0C1BDB46AE4E8B5270E4BF9/file">
                    </span>
                    <div>
                        <span> 클랜징</span>
                    </div>
                      <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22296'}}"></router-link>
                </button>
                 <button @click="clickList_8">
                    <span>  
                        <img src="https://contents.lotteon.com/display/dshop/22289/P20495AE75B7780F677A9CB7EE0532441543425EC91D4018CFBB04049BF5C2A89/file">
                    </span>
                    <div>
                        <span> 향수</span>
                    </div>
                      <router-link :to="{name: 'prdList', params:{pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22289'}}"></router-link>
                </button>
                <button type="button" class="cart_img" @click="cartList">
                  <img
                  src="@/assets/cart_img.jpg"
                  width="80px"
                  height="80px">
                  <h2>장바구니</h2>
                </button>

            </ul>
        </div>
    </div>
   

</template>

<script>

export default {
    name: "PrdCat", 
       methods:{
         
           clickList_1() {
              this.$router.push({name: 'prdList', params: {dshopNo: '22276'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_2() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22279'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_3() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22280'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_4() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22282'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_5() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22284'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_6() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22286'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_7() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22296'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
           clickList_8() {
              this.$router.push({name: 'prdList', params: {pdSortCd: '01', pageNo: '01', rowsPerPage: '60', dshopNo: '22289'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
           },
      cartList(){
        this.$router.push({name: 'cartList', params:{mbNo: '11'}}).catch(err =>{
        if(err.name != "NavigationDuplicated" ){
          throw err;
        }
      });
      }
       }
       
    }
</script>

<style>
.cat-block{
    margin-top: 3%;
    margin-left: 400px;
    margin-bottom: 3%;
}

</style>
