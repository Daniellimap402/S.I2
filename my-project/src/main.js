import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import VueRouter from 'vue-router'
import Games from './components/Games.vue'
import Game from './components/Game.vue'
import Home from './components/Home.vue'

Vue.use(BootstrapVue)
Vue.use(VueRouter)
Vue.config.productionTip = false

const router = new VueRouter({
  routes: [
    {
      path: '/home',
      component : Home
    },
    {
      path: '/games',
      component : Games
    },
    {
      path: '/game/',
      component : Game
    },
    {
      path : '/',
      redirect : '/home'
    }
  ]
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')


