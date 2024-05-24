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
    <v-row>
      <v-col cols="4" v-for="project in projects">
        <router-link :to="'/projects/'+project.id" style="text-decoration: none">
          <v-hover>
            <template v-slot:default="{ isHovering, props }">
              <v-card
                  v-bind="props"
                  :color="isHovering ? 'primary' : undefined"
                  class="pa-2"
              >
                <v-img
                    class="align-end text-white"
                    height="200"
                    :src="project.images ? baseUrl + project.images[Object.keys(project.images)[0]] : baseUrl + 'src/assets/images/no-photo-available.png'"
                    cover
                ></v-img>
                <div style="height: 150px">
                  <v-card-title class="pt-4">{{project.title}}</v-card-title>
                  <v-card-text>
                    <v-chip-group v-if="project.tags">
                      <v-chip v-for="tag of project.tags" density="compact">{{tag}}</v-chip>
                    </v-chip-group>
                    {{project.bio}}
                  </v-card-text>
                </div>
              </v-card>
            </template>
          </v-hover>
        </router-link>
      </v-col>
    </v-row>
  </div>
</template>

<style scoped>
.container{
  width: 90%;
  margin-left: 5%;
}
</style>