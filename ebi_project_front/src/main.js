import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import vuetify from './plugins/vuetify';
import VueRouter from 'vue-router';
import router from './router'

Vue.config.productionTip = false
Vue.prototype.axios = axios
Vue.use(VueRouter)

new Vue({
  render: h => h(App),
  vuetify,
  router
}).$mount('#app')
