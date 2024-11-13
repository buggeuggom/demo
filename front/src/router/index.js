import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EquipmentsVue from "@/views/equipment/EquipmentsVue.vue";
import EquipmentVue from "@/views/equipment/EquipmentVue.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/equipments',
      name: 'equipments',
      component: EquipmentsVue,
    },
    {
      path: '/equipments/:id',
      name: 'equipment',
      component: EquipmentVue,
      props: true
    },
  ],
})

export default router
