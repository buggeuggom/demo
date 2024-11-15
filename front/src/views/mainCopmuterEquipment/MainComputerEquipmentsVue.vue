<script setup lang="js">

import {onMounted, ref} from "vue";
import axios from "axios";

const currentPage = ref(1);
const totalItems = ref(0);

const use = ref("");
const equipmentName = ref("");

const equipments = ref(Array(10).fill({
  id: 0,
  use: "",
  equipmentName: "",
  modelName: "",
  os: "",
  introductionDate: "",
  assetNumber: "",
  sn: "",
  number: ""
}));
const param = ref({})

const search = () => {
  const param = {}
  axios.get(`/api/main-computer-equipments`, {
    params: {
      page: currentPage.value,
      size: 10,
      use: use.value,
      equipmentName: equipmentName.value
    }
  }).then(respone => {
      equipments.value = []

      if (respone.data.items.length == 0) {
        equipments.value = Array(10).fill({
          id: 0,
          use: "",
          equipmentName: "",
          modelName: "",
          os: "",
          introductionDate: "",
          assetNumber: "",
          sn: "",
          number: ""
        })
        totalItems.value = 0;

        alert("장비가 없습니다.")
      }
      totalItems.value = respone.data.totalCount || 0

      respone.data.items.forEach((r) => {
        equipments.value.push(r)
      })
    }).catch((err) => {
    alert("서버에 문제가 발생했습니다.")
  })

}

const handlePageChange = (newPage) => {
  currentPage.value = newPage;
  search();
};


onMounted(() => {
  search()
})

</script>

<template>
  <el-container>
    <el-text class="mx-1" size="large">주 전산 장비 현황(서버)</el-text>
  </el-container>
  <br>
  <el-container>
    <el-input style="width: 50%" v-model="use" placeholder="용도">
      <template #prepend>
        용도
      </template>
    </el-input>
    <el-input style="width: 50%" v-model="equipmentName" placeholder="장비명">
      <template #prepend>
        장비명
      </template>
    </el-input>
    <el-button type="primary" @click="search()">검색</el-button>
  </el-container>

  <table>
    <thead>
    <tr>
      <th>용도</th>
      <th>장비명</th>
      <th>모델명</th>
      <th>OS</th>
      <th>도입일자</th>
      <th>자산번호</th>
      <th>SN</th>
      <th>번호</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="equipment in equipments" :key="equipment.id">
      <td>{{ equipment.use || "-" }}</td>
      <td>
        <router-link :to="{ name: 'main-computer-equipment', params: {id: equipment.id}}">
          {{ equipment.equipmentName || "-" }}
        </router-link>
      </td>
      <td>{{ equipment.modelName || "-" }}</td>
      <td>{{ equipment.os || "-" }}</td>
      <td>{{ equipment.introductionDate || "-" }}</td>
      <td>{{ equipment.assetNumber || "-" }}</td>
      <td>{{ equipment.sn || "-" }}</td>
      <td>{{ equipment.number || "-" }}</td>
    </tr>
    </tbody>
  </table>

  <el-pagination
    background
    layout="prev, pager, next, total"
    :total="totalItems"
    :current-page="currentPage"
    @current-change="handlePageChange"
  />
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
