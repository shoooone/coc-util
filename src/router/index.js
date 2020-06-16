import Vue from 'vue';
import VueRouter from 'vue-router';
import Top from '../views/Top.vue';
import Clans from '../views/Clans.vue';
import Ranking from '../views/Ranking.vue';
import Layouts from '../views/Layouts.vue';
import LayoutsUpload from '../views/LayoutsUpload.vue';

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
  {
    path: '/ranking',
    name: 'Ranking',
    component: Ranking,
  },
  {
    path: '/layouts',
    name: 'Layouts',
    component: Layouts,
  },
  {
    path: '/layouts-upload',
    name: 'LayoutsUpload',
    component: LayoutsUpload,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
