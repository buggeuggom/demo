<script setup lang="js">

import {onMounted, ref} from "vue";
import axios from "axios";

const currentPage = ref(1);
const pageSize = ref(10);
const req = ref("");
const equipments = ref(Array(10).fill({
  id:0,
  use: "",
  equipmentName: "",
  modelName: "",
  os:"",
  introductionDate:"",
  assetNumber:"",
  sn:"",
  number:""
}));
const param = ref({
  page
})

const search = ()=>{
  const param = {}
  axios.get(`/api/main-computer-equipments`)
    .then(respone=>{
      equipments.value = []

      if(respone.data.length == 0){
        equipments.value =  Array(10).fill({
          id:0,
          use: "",
          equipmentName: "",
          modelName: "",
          os:"",
          introductionDate:"",
          assetNumber:"",
          sn:"",
          number:""
        })

        alert("장비가 없습니다.")
      }

      respone.data.items.forEach((r)=>{
        equipments.value.push(r)
      })
    })
}

onMounted(() => {
  search()
})

</script>

<template>
  <el-container>
    <el-input style="width: 50%" v-model="req" placeholder="예비인자">
      <template #prepend>
        예비인자
      </template>
    </el-input>
    <el-button type="primary" @click="search()">검색</el-button>
  </el-container>

  <table>
    <thead>
    <tr>
      <th>용도</th>
      <th>모델명</th>
      <th>장비명</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="equipment in equipments" :key="equipment.id">
      <td>
        <router-link :to="{ name: 'equipment', params: {id: equipment.id}}">
          {{ equipment.use || "-" }}
       </router-link>
      </td>
      <td>{{ equipment.modelName || "-" }}</td>
      <td>{{ equipment.equipmentName || "-" }}</td>
    </tr>
    </tbody>
  </table>

  <el-pagination background layout="prev, pager, next" :total="1000" />

</template>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  font-family: Arial, sans-serif;
}

th, td {
  border: 1px solid #ddd;
  padding: 12px;
  text-align: left; /* 텍스트를 왼쪽 정렬 */
}

th {
  background-color: #f4f4f4;
  color: #333;
  font-weight: bold;
  text-align: center; /* 헤더 텍스트를 중앙 정렬 */
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

tr:hover {
  background-color: #f1f1f1;
}

input {
  padding: 8px;
  margin-right: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 8px 12px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
