import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import MainComputerEquipments from "@/views/mainCopmuterEquipment/MainComputerEquipmentsVue.vue";
import EquipmentVue from "@/views/mainCopmuterEquipment/EquipmentVue.vue";
import ServersVue from "@/views/server/ServersVue.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/servers',
      name: 'servers',
      component: ServersVue,
    },
    {
      path: '/main-computer-equipments',
      name: 'main-computer-equipments',
      component: MainComputerEquipments,
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
