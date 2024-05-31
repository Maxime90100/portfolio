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
    ],
    icons: [
      {icon: 'mdi-linkedin', color: '#126BC4', path: 'https://www.linkedin.com/in/maxime-theveneau-401462219/'},
      {icon: 'mdi-github', color: '#6F6EF1', path: 'https://github.com/Maxime90100'}
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
    <v-footer class="d-flex flex-column mt-10 pa-5">
      <v-row style="align-items: center">
        <v-btn
            v-for="icon in icons"
            :key="icon"
            :icon="icon.icon"
            :color="icon.color"
            :href="icon.path"
            target="_blank"
            class="mx-4"
            variant="text"
        ></v-btn>
        <routerLink to="/" style="text-decoration: none; color: white">
          <v-btn
              :text="new Date().getFullYear() + ' — Portfolio '"
              class="mx-4"
              variant="plain"
          ></v-btn>
        </routerLink>
      </v-row>
    </v-footer>
  </v-app>
</template>

<style scoped>

</style>