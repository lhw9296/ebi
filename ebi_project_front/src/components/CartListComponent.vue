<template>
  <div class="cartListWrapper">
    <div class="cartHeader">
      <div class="checkboxSet">
        <input type="checkbox">
        <label>{{this.trNo}}</label>
      </div>
    </div>
    <ul>
      <!-- product component 를 사용하여 나눔 -->
     <cart-product-component
     v-for="i in this.group"
     :cartLists="i"
     :key="i.cartSn"
     />
    </ul>
  </div>
</template>

<script>
import CartProductComponent from '../components/CartProductComponent'

export default {
  name: "cartList",
  components:{
    CartProductComponent
  },
  props:{
    group: Array
  },
  data: function() {
    return{
      trNo: this.group[0].trNo
    }
  }
};
</script>

<style>

.cartHeader{
  margin-top: 50px;
  margin-left: 300px;
  width: 700px;
  border: 1px solid  #ddd;
}
.cartListWrapper .cartHeader input{
      display: inline-block;
    width: 18px;
    height: 18px;
    margin-top: 5px;
    margin-right: 11px;
    border-radius: 11px;
    border: 1px solid #bfbfbf;
    background-color: #fff;
    vertical-align: top;

}

</style>