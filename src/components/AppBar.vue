<script>
export default {
  name: 'AppBar',
  props: ['routes'],
  data:()=>({
    drawer: false,
    group: null,
  }),
  methods: {
    goTo(path){
      this.$router.push(path);
    }
  },
  watch: {
    group () {
      this.drawer = false
    },
  }
}
</script>

<template>
  <div>
    <v-app-bar color="background" scroll-behavior="hide" prominent>
      <v-toolbar-title><v-btn icon="mdi-home-outline" variant="plain" @click="goTo('/')"></v-btn></v-toolbar-title>
      <v-spacer></v-spacer>
      <template v-slot:append>
        <div v-if="$vuetify.display.mdAndUp">
          <v-btn
              v-for="route in routes"
              :to="route.path"
              class="mr-4"
              :prepend-icon="route.icon"
              :text="route.name"
          ></v-btn>
        </div>
        <v-app-bar-nav-icon v-else variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      </template>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" location="right" color="secondary" temporary>
      <v-list>
        <router-link
            v-for="route in routes"
            :key="route.path"
            :to="route.path"
            style="text-decoration: none; color: white"
        >
          <v-list-item>
            <template v-slot:prepend>
              <v-icon :icon="route.icon"></v-icon>
            </template>
            <v-list-item-title v-text="route.name"></v-list-item-title>
          </v-list-item>
        </router-link>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<style scoped>

</style>