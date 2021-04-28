import VueRouter from 'vue-router'

import PrdListView from '../views/PrdListView'
import CartView from '../views/CartView'


const routes =[
    {path:'/', name:'proListView', component: PrdListView},
    {path:'/product/:pdSortCd/:pageNo/:rowsPerPage/:dshopNo', name:'prdList', component: PrdListView},
    {path:'/cart/:mbNo', name:'cartList', component: CartView }

]
console.log(routes)

export default new VueRouter({
    mode: 'history',
    routes : routes
})
