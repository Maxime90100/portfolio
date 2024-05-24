<script>
export default{
  name:'ProjectCards',
  props:['projects'],
  computed: {
    baseUrl() {
      return import.meta.env.BASE_URL
    },
  }
}
</script>

<template>
  <div class="container">
    <h1 class="text-primary">Projets</h1>
    <div class="cards-container">
      <v-card
          v-for="project in projects"
          class="card"
      >
        <v-img
            class="align-end text-white"
            height="200"
            :src="baseUrl + project.images[Object.keys(project.images)[0]]"
            cover
        ></v-img>

        <v-card-title class="pt-4">{{project.title}}</v-card-title>
        <v-card-text>{{project.bio}}</v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <router-link :to="'/projects/'+project.id">
            <v-btn color="secondary" text="Découvrir"></v-btn>
          </router-link>
        </v-card-actions>
      </v-card>
    </div>
  </div>
</template>

<style scoped>
.container{
  width: 90%;
  margin-left: 5%;
}
.cards-container{
  display: flex;
  gap: 10px;
}
.cards-container .card{
  width: 33%;
}
</style>