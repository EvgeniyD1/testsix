<template>
  <v-app>
    <v-app-bar>
      <v-toolbar-title>TestSixApplication</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn @click="getRuUsers">RU</v-btn>
      <v-btn @click="getUaUsers">UA</v-btn>
      <v-btn @click="getUsUsers">US</v-btn>

      <template v-slot:extension>
        <v-slider
            v-model="errors"
            :min="0"
            :max="10"
            :step="1"
            thumb-label
        ></v-slider>
      </template>
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

    <div ref="observer"></div>
  </v-app>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      records: [],
      type: '',
      errors: 0
    }
  },
  methods: {
    async getRuUsers() {
      if (this.type!=='ru') this.records = [];
      let url = '/ru?errors=' + this.errors;
      this.type = 'ru';
      const response = await axios.get(url);
      this.records = [...this.records, ...response.data];
    },
    async getUaUsers() {
      if (this.type!=='ua') this.records = [];
      let url = '/ua?errors=' + this.errors;
      this.type = 'ua';
      const response = await axios.get(url);
      this.records = [...this.records, ...response.data];
    },
    async getUsUsers() {
      if (this.type!=='us') this.records = [];
      let url = '/us?errors=' + this.errors;
      this.type = 'us';
      const response = await axios.get(url);
      this.records = [...this.records, ...response.data];
    }
  },
  // mounted() {
  //   window.onscroll = () => {
  //     const el = document.documentElement;
  //     const isBottomOfScreen = el.scrollTop + window.innerHeight === el.offsetHeight;
  //     if (isBottomOfScreen) {
  //       console.log(isBottomOfScreen)
  //       if (this.type==='ru') this.getRuUsers();
  //       if (this.type==='ua') this.getUaUsers();
  //       if (this.type==='us') this.getUsUsers();
  //     }
  //   }
  // },
  // beforeUnmount() {
  //   window.onscroll = null
  // }
  mounted() {
    const options = {
      rootMargin: '0px',
      threshold: 1.0
    }
    const callback = (entries, observer) => {
      if (entries[0].isIntersecting){
        if (this.type==='ru') this.getRuUsers();
        if (this.type==='ua') this.getUaUsers();
        if (this.type==='us') this.getUsUsers();
      }
    };
    const observer = new IntersectionObserver(callback, options);
    observer.observe(this.$refs.observer);
  }
}
</script>

<style>
body {
  padding-top: 120px;
}
</style>