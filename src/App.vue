<template>
  <v-app>
    <v-app-bar :elevation="2">
      <template #prepend>
        <v-app-bar-nav-icon></v-app-bar-nav-icon>
      </template>

      <v-app-bar-title>Portfolio</v-app-bar-title>

      <template #append>
        <router-link
            v-for="route in routes"
            :key="route.name"
            :to="route.path"
            class="mr-4"
        >{{ route.name }}</router-link>
      </template>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue';
const routes = ref([
  { name: 'Projets', path: '/projects' },
  { name: 'Experience', path: '/experiences' },
  { name: 'Formation', path: '/education' },
  { name: 'Compétences', path: '/competences' },
  { name: 'A propos', path: '/about' }
]);
</script>
