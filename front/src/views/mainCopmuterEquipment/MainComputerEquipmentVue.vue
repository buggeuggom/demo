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
  id: 0,
  departmentName: "",
  operator: "",
  contactNumber: 0,
  use: "",
  modelName: "",
  equipmentName: ""
})

const serverStorageIntros = ref(Array(5).fill({
  id: 0,
  name: "",
  quantity: "",
  introductionYear: ""
}))


onMounted(() => {
  axios.get(`/api/main-computer-equipments/${props.id}`).then(res => {

    equipment.value = res.data;

  })

  axios.get(`/api/main-computer-equipments/${props.id}/server-storage-intro`).then(res => {

    serverStorageIntros.value = []
    console.log(res.data);
    res.data.forEach((r) => {
      serverStorageIntros.value.push(r)
    })
  })

})
</script>

<template>
  <el-descriptions title="주전산장비 사양 관리 대장" :column="4" border>
    <el-descriptions-item4
      label="용도"
      label-align="center"
      align="center"
      label-class-name="my-label"
      class-name="my-content"
    >
      {{ equipment.use }}
    </el-descriptions-item4>

    <el-descriptions-item label="장비명" label-align="center" align="center">
      {{ equipment.modelName || "-" }}
    </el-descriptions-item>

    <el-descriptions-item label="OS" label-align="center" align="center">
      {{ equipment.os || "-" }}
    </el-descriptions-item>

    <el-descriptions-item label="도입일자" label-align="center" align="center">
      {{ equipment.introductionDate || "-" }}
    </el-descriptions-item>

    <el-descriptions-item label="자산번호" label-align="center" align="center">
      {{ equipment.assetNumber || "-" }}
    </el-descriptions-item>

    <el-descriptions-item label="SN" label-align="center" align="center">
      {{ equipment.sn || "-" }}
    </el-descriptions-item>

    <el-descriptions-item label="번호" label-align="center" align="center">
      {{ equipment.number || "-" }}
    </el-descriptions-item>
    <el-descriptions-item label="" label-align="center" align="center">
      {{ "-" }}
    </el-descriptions-item>
    <el-descriptions-item label="" label-align="center" align="center">
      {{ "-" }}
    </el-descriptions-item>
  </el-descriptions>
  <br>
  <el-row>
    <el-col :span="24"><div class="grid-content ep-bg-purple-dark" />스토리지 도입 현황</el-col>
  </el-row>
<br>
  <el-table :data="serverStorageIntros" style="width: 100%">
    <el-table-column prop="name" label="도입차수" width="180" />
    <el-table-column prop="quantity" label="도입량" width="180" />
    <el-table-column prop="introductionYear" label="도입년도" />
  </el-table>

</template>

<style scoped>

</style>
