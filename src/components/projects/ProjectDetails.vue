<script>
export default {
  name:'ProjectDetails',
  props:['project']
}
</script>

<template>
  <v-container v-if="project">
    <div class="row">
      <router-link to="/projects"><v-icon>mdi-arrow-left</v-icon></router-link>
      <h1 class="text-primary">{{project.title}}</h1>
    </div>
    <v-row v-for="section of project.body">
      <v-col cols="12">
        <v-card>
          <v-card-title class="text-h5">{{section.title}}</v-card-title>
          <v-card-text style="white-space: pre-line;">{{section.description}}</v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>