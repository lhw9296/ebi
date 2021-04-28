<template>
    <div>
    <!-- List 전체 Container -->
  <div class="container">
    <h2 class="pageTitle">
      장바구니
    </h2>
    <hr>
  </div> 
  <div>
    <!-- List component  -->
    <cart-list-component
    v-for="group, index in this.groupCartArr"
    :group="group"
    :key="index"
    />
  </div>
    <div>
      <!-- total price component -->
        <cart-price-component
        />
    </div>
    </div>
</template>

<script>
import {CartApi} from '../api'
import CartListComponent from '../components/CartListComponent.vue'
import EventBus from '../utils/EventBus'
import CartPriceComponent from '../components/CartPriceComponent.vue'

export default {
    name: "CartView",
    components: {
        CartListComponent,
        CartPriceComponent
    },
    data: function() {
      return{
        cartPrdInfoArr: [],
        groupCartArr:[]

      }
    },
    created: function(){
      this.retrieveByCartList();

      EventBus.$on('modifyCart', this.modifyCart);
      EventBus.$on('cartPriceInfo', this.cartPriceInfo);
    },
    methods: {
      retrieveByCartList: async function(){
        let trNoGroup = {};
        await CartApi.retrieveByCartList().then(r => {
          this.cartPrdInfoArr = r.data;

          console.log("final",r)
          console.log("Views",this.cartPrdInfoArr)
        });

        this.cartPrdInfoArr.forEach(e => {
          if(!Object.keys(trNoGroup).includes(e.trNo)){
            trNoGroup[e.trNo] = [];
          }
          trNoGroup[e.trNo].push(e);
        
        });

        Object.keys(trNoGroup).forEach(key => {
          this.groupCartArr.push(trNoGroup[key])
        });
      },
      // eventBus 를 통한 통신
      modifyCart: function(cartLists){
      CartApi.modify(cartLists)
      },
      cartPriceInfo: function(){
       
      }
  }
}
</script>

<style>
.container{
    max-width: 1000px;
    margin-top: 200px;
}
.pageTitle{
  padding-top: 30px;
    margin-bottom: 30px;
    font-size: 40px;
    line-height: 1px;
    letter-spacing: -1.1px;
    text-align: center;
    color: #333;
}

.cartContent.detailWrap{
    width: 786px;
}
.itemController{
    float: left;
    width: 70%;
    padding: 0 0 12px;
}
.itemController.checkboxController{
    float: left;
    font-size: 0;
    line-height: 32px;
    letter-spacing: -.3px;
    color: #333;
  margin-top: 100px;

}
.itemController.checkboxController input{
    margin-right: 10px;
    vertical-align: middle;

}
.cur_hand{
  cursor: pointer;
  outline: none;
  margin-top: 30px;
}

.input[type=checkbox]{
      display: inline-block;
    width: 18px;
    height: 18px;
    border-radius: 4px;
}
.itemController.checkboxController label{
  display: inline-block;
    padding-left: 0;
    font-size: 14px;
    line-height: 32px;
}
.deleteBtngroup{
  float: right;
}
.itemController button.deleteCartItems[data-v-7f6b5e24] {
    float: right;
    height: 32px;
    padding: 0 12px;
    margin-left: 8px;
    font-size: 13px;
    line-height: 32px;
    letter-spacing: -.2px;
    text-align: center;
    color: #333;
    border-radius: 6px;
    border: 1px solid #ddd;
}
</style>