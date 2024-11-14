<script setup>
import {onMounted, ref} from "vue";
import axios from "axios";

const props = defineProps({
    id: {
      required: true
    }
  }
)
const equipment = ref({
  id:0,
  departmentName:"",
  operator:"",
  contactNumber: 0,
  use:"",
  modelName: "",
  equipmentName: ""
})
onMounted(()=>{
  axios.get(`/api/equipments/${props.id}`).then(res=>{
    equipment.value = []
    console.log(res.data)
    equipment.value = res.data;
  })
})
</script>

<template>
  <el-descriptions title="주전산장비 사양 관리 대장" :column="3" border>
    <el-descriptions-item
      label="부서명"
      label-align="center"
      align="center"
      label-class-name="my-label"
      class-name="my-content"
    >
      {{equipment.departmentName}}
    </el-descriptions-item>

    <el-descriptions-item label="운영자" label-align="center" align="center">
      {{equipment.operator}}
    </el-descriptions-item>
    <el-descriptions-item label="연락처" label-align="center" align="center">
      {{equipment.contactNumber}}
    </el-descriptions-item>
    <el-descriptions-item label="용도" label-align="center" align="center">
      {{equipment.use}}
    </el-descriptions-item>
    <el-descriptions-item label="모델명" label-align="center" align="center">
    {{equipment.modelName}}
  </el-descriptions-item>
    <el-descriptions-item label="장비명" label-align="center" align="center">
    {{equipment.equipmentName}}
  </el-descriptions-item>
  </el-descriptions>
</template>

<style scoped>

</style>
