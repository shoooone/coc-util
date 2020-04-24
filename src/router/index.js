import Vue from 'vue';
import VueRouter from 'vue-router';
import Top from '../views/Top.vue';
import Clans from '../views/Clans.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Top',
    component: Top,
  },
  {
    path: '/clans',
    name: 'Clans',
    component: Clans,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
