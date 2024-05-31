<script>
export default{
  name:'ProjectCards',
  props:['projects'],
  data:()=>({
    selectedTags:[],
    filter: false
  }),
  computed: {
    filteredProjects(){
      return this.filter
          ? this.projects.filter(p => {
            if (!p.tags) return false;
            return p.tags.some(tag => this.selectedTags.includes(tag));
          })
          : this.projects
    },
    tags(){
      const tags = this.projects.flatMap(project => project.tags);
      return [...new Set(tags)];
    }
  }
}
</script>

<template>
  <div class="container">

    <v-row>
      <v-btn
          v-if="!filter"
          @click="filter = true"
          prepend-icon="mdi-filter"
          text="filtres"
          variant="plain"
          color="primary"
          class="ml-3 mr-5"
      ></v-btn>
      <v-select
          v-else
          label="Étiquettes"
          placeholder="Choisissez les étiquettes filtrantes"
          v-model="selectedTags"
          :items="tags"
          :hint="`${filteredProjects.length} projet(s) correspondant(s)`"
          color="primary"
          persistent-hint
          multiple
          clearable
          chips
      >
        <template v-slot:prepend-inner>
          <v-btn
              icon="mdi-filter-off"
              color="primary"
              variant="plain"
              @click="filter = false"
          ></v-btn>
        </template>
      </v-select>
    </v-row>

    <div
        v-if="filteredProjects.length > 0"
        class="cards-container"
    >
        <router-link
            v-for="project in filteredProjects"
            :to="'/projects/'+project.id"
            class="card"
        >
          <v-hover>
            <template v-slot:default="{ isHovering, props }">
              <v-card
                  v-bind="props"
                  :color="isHovering ? 'secondary' : undefined"
                  class="pa-4"
                  style="border-radius: 30px"
              >
                <v-img
                    class="align-end text-white"
                    style="border-radius: 30px"
                    height="200"
                    :src="
                      project.image
                        ? project.image
                        : project.images
                          ? project.images[Object.keys(project.images)[0]]
                          : 'images/no-photo-available.png'"
                    cover
                ></v-img>
                <div style="height: 180px">
                  <v-card-title class="pa-1" style="white-space: normal">{{project.title}}</v-card-title>
                  <v-card-text class="pa-0">
                    <v-chip-group v-if="project.tags">
                      <v-chip
                          v-for="tag of project.tags"
                          density="compact"
                          :text="tag"
                      ></v-chip>
                    </v-chip-group>
                    {{project.bio}}
                  </v-card-text>
                </div>
              </v-card>
            </template>
          </v-hover>
        </router-link>
    </div>

    <v-empty-state
        v-else
        icon="mdi-magnify"
        title="Aucun projet ne correspond à votre recherche."
        text="Essayez d'ajuster vos termes de recherche."
        class="mt-10"
    >
      <v-btn text="supprimer les filtres" variant="plain" @click="filter = false"></v-btn>
    </v-empty-state>
  </div>
</template>

<style scoped>
.container{
  width: 90%;
  margin-left: 5%;
}
.cards-container{
  display: flex;
  flex-wrap: wrap;
  margin-top: 30px;
}
.card{
  text-decoration: none;
  padding: 10px;
  width: 25%;
}

@media (max-width: 1200px) {
  .card{
    width: 33.3%;
  }
}
@media (max-width: 800px) {
  .card{
    width: 50%;
  }
}
@media (max-width: 650px) {
  .card{
    width: 100%;
  }
}
</style>