<template>
   <div>
          <div id="sideArea" class="cartPriceWing">
            <div class="priceWrap vue-affix affix-top">
              <div class="inner">
                <div class="priceTitle">
                    결제예정금액
                </div>
                <div class="priceList">
                  <dl>
                  <dt>
                      상품금액
                  </dt>
                  <dd>
                        120,900
                    <span>원</span>
                  </dd>
                  </dl>
                  <dl>
                    <dt>배송비</dt>
                    <dd><span>5,000원</span></dd>
                  </dl>
                  <dl>
                    <dt>
                      상품할인금액
                    </dt>
                    <dd>
                      0
                      <span>원</span>
                    </dd>
                  </dl>
                </div>
                <div class="totalPrice">
                  <dt>
                    총
                    <span class="colorPrimary">2</span>
                    건
                  </dt>
                  <dd class="price">
                    <strong class="price colorPrimary">100,000</strong>
                    <span class="won colorPrimary">원</span>
                  </dd>
                </div>
                <ul class="cartBtnSet">
                  <li class="topOrderBtn">
                    <a type="button" class="btnOrder">주문하기</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
</template>
 
<script>

export default {
    name: "cartPrice",
    data: function(){
        return {
          
        }
    }
    

}
</script>

<style>
/* 결제창 style */
#sideArea.cartPriceWing{
      position: absolute;
    top: 320px;
    right: 300px;
    width: 298px;
    height: 100%;
    z-index: 5;
}
#sideArea.cartPriceWing.priceWrap{
  width: 298px;
}
.vue-affix.affix-top{
      position: static!important;
}
#sideArea.cartPriceWing.priceWrap.inner{
    width: 100%;
    background: #fff;
    box-sizing: border-box;
    border: 1px solid #ddd;
    border-radius: 10px;
    padding: 24px 20px 20px 20px;

}
#sideArea.cartPriceWing.priceWrap.priceTitle{
  font-size: 40px;
    line-height: 1.4;
    letter-spacing: -.06em;
    margin-bottom: 28px;
}
#sideArea.cartPriceWing .priceWrap .priceList{
    border-bottom: 1px solid #eee;
    padding-bottom: 18px;
}
#sideArea.cartPriceWing .priceWrap .priceList dl{
    display: table;
    table-layout: fixed;
    width: 100%;
    margin-top: 12px;
    margin-bottom: 0;
    line-height: normal;
}
#sideArea.cartPriceWing .priceWrap .priceList dl dt{
    position: relative;
    width: 50%;
    display: table-cell;
    padding-top: 3px;
    font-size: 20px;
    color: #757575;
    line-height: 1.57;
    letter-spacing: -.3px;
    vertical-align: top;
    white-space: normal;
}
#sideArea.cartPriceWing .priceWrap .priceList dl dd{

  font-size: 25px;

}

/* 총 결제금액 창 */
#sideArea.cartPriceWing.priceWrap.totalPrice{
  display: flex;
  margin-top: 17px;
}
#sideArea.cartPriceWing .priceWrap .totalPrice dt{
  -webkit-box-flex: 0;
    flex: none;
    font-size: 20px;
    letter-spacing: -.03em;
    padding-top: 7px;
}

.colorPrimary{
  color: #ef2a23;
}
#sideArea.cartPriceWing .priceWrap .totalPrice dd{
    -webkit-box-flex: 1;
    flex: 1;
    margin-left: 150px;
    font-size: 25px;
}
.btnOrder{
    display: block;
    line-height: 52px;
    text-align: center;
    font-size: 25px;
    background: #ef2a23;
    color: #fff;
    border-radius: 6px;
    margin-top: 40px;
}
.cartBtnSet .topOrderBtn{
  list-style: none;
}
</style>