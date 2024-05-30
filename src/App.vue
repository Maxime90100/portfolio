<script>
import AppBar from "@/components/AppBar.vue";

export default {
  components: {AppBar},
  data:()=>({
    routes: [
      { name: 'Projets', path: '/projects', icon: 'mdi-folder-outline' },
      { name: 'Experience', path: '/experiences', icon: 'mdi-source-branch' },
      { name: 'Compétences', path: '/competences', icon: 'mdi-application-brackets-outline' },
      { name: 'A propos', path: '/about', icon: 'mdi-information-outline' }
    ]
  })
}
</script>

<template>
  <v-app>
    <AppBar :routes="routes"></AppBar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<style scoped>

</style>