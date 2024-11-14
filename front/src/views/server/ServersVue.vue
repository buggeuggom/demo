<script setup lang="js">

import {onMounted, ref} from "vue";
import axios from "axios";

const page = ref(0);
const totalPage = ref(100);
const totalElementCount = ref(0);

const req = ref("");
const servers = ref(Array(10).fill({
  id: 0,
  host: "",
  hostName: "",
  ipAddress: "",
  os: "",
  serialNumber: "",
  vmName: "",
  vmNameKo: "",
  veamBackup: false
}));

const search = () => {

  const queryParam = {page: page.value, size: 10}
  axios.get(`/api/servers`, {params: queryParam})
    .then(respone => {
      servers.value = []

      if(respone.data.items.length == 0){
        servers.value =  Array(10).fill({
          id: 0,
          host: "",
          hostName: "",
          ipAddress: "",
          os: "",
          serialNumber: "",
          vmName: "",
          vmNameKo: "",
          veamBackup: false
        })

        alert("장비가 없습니다.")
      }
      page.value = respone.data.page;
      totalPage.value = respone.data.size;
      totalElementCount.value = respone.data.totalCount;

      respone.data.items.forEach((r)=>{
        servers.value.push(r)
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
      <th>연번</th>
      <th>VM name</th>
      <th>VM name ko</th>
      <th>Host Name</th>
      <th>Host</th>
      <th>os</th>
      <th>IP Address</th>
      <th>Veam 백업여부</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="server in servers" :key="server.id">
      <td>{{ server.serialNumber || "-" }}</td>
      <td>{{ server.vmName || "-" }}</td>
      <td>{{ server.vmNameKo || "-" }}</td>
      <td>{{ server.hostName || "-" }}</td>
      <td>{{ server.host || "-" }}</td>
      <td>{{ server.os || "-" }}</td>
      <td>{{ server.ipAddress || "-" }}</td>
      <td>{{ (server.veamBackup)? "O":"X" }}</td>
    </tr>
    </tbody>
  </table>

  <el-pagination background layout="prev, pager, next" :total="totalPage.value"/>

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
