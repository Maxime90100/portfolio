<script>
export default {
  name: "ExperienceDetails",
  props: ['experience']
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