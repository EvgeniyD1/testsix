<template>
  <v-app>
    <v-app-bar>
      <v-toolbar-title>TestSixApplication</v-toolbar-title>
      <div>
        {{ type }}
      </div>
      <v-btn @click="getRuUsers">RU</v-btn>
      <v-btn @click="getUaUsers">UA</v-btn>
      <v-btn @click="getUsUsers">US</v-btn>
    </v-app-bar>
    <v-table
        fixed-header
        v-if="records.length!==0"
    >
      <thead>
      <tr>
        <th class="text-left">Number</th>
        <th class="text-left">Id</th>
        <th class="text-left">Name</th>
        <th class="text-left">Phone Number</th>
        <th class="text-left">Address</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="record in records" :key="record.number">
        <td>{{ record.number }}</td>
        <td>{{ record.id }}</td>
        <td>{{ record.username }}</td>
        <td>{{ record.phoneNumber }}</td>
        <td>{{ record.address }}</td>
      </tr>
      </tbody>
    </v-table>
  </v-app>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      records: [],
      type: ''
    }
  },
  methods: {
    async getRuUsers(){
      let url = '/ru';
      const response = await axios.get(url);
      this.records = response.data;
    },
    async getUaUsers(){
      let url = '/ua';
      const response = await axios.get(url);
      this.records = response.data;
    },
    async getUsUsers(){
      let url = '/us';
      const response = await axios.get(url);
      this.records = response.data;
    }
  }
}
</script>

<style>
body {
  padding-top: 70px;
}
</style>