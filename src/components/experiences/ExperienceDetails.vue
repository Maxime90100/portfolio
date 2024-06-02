<script>
export default {
  name: "ExperienceDetails",
  props: ['experience'],
  computed: {
    baseUrl() {
      return import.meta.env.BASE_URL
    },
  }
}
</script>

<template>
  <div class="card">
    <routerLink to="/experiences" style="text-decoration: none; color: white">
      <v-btn prepend-icon="mdi-arrow-left" variant="plain" text="retour"></v-btn>
    </routerLink>
    <v-card>
      <v-card-title>{{experience.title}}</v-card-title>
      <v-card-subtitle class="mb-5">{{experience.startTime}} - {{experience.endTime}}</v-card-subtitle>
      <v-card-subtitle>{{experience.place.name}}</v-card-subtitle>
      <v-btn
          v-if="experience.place && experience.place.website"
          prepend-icon="mdi-web"
          variant="text"
          color="primary"
          :href="experience.place.website"
          text="site web"
      ></v-btn>
      <v-card-text>{{experience.description}}</v-card-text>
      <v-list v-if="experience.files">
        <v-list-item v-for="(file, key) of Object.entries(experience.files)" :key="key">
          <a :href="baseUrl + file[1]" :download="file[0]">
            <v-btn prepend-icon="mdi-download" :text="file[0]" variant="plain"></v-btn>
          </a>
        </v-list-item>
      </v-list>
    </v-card>
  </div>
</template>

<style scoped>
.card *{
  white-space: pre-line;
}
.card{
  width: 60%;
  margin-left: 20%;
}
@media (max-width: 800px) {
  .card{
    width: 90%;
    margin-left: 5%;
  }
}
</style>