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

    <v-row v-if="filteredProjects.length > 0">
      <v-col v-for="project in filteredProjects">
        <router-link :to="'/projects/'+project.id" style="text-decoration: none">
          <v-hover>
            <template v-slot:default="{ isHovering, props }">
              <v-card
                  v-bind="props"
                  :color="isHovering ? 'primary' : undefined"
                  class="pa-4"
                  style="border-radius: 30px"
              >
                <v-img
                    class="align-end text-white"
                    height="200"
                    :src="
                      project.image
                        ? project.image
                        : project.images
                          ? project.images[Object.keys(project.images)[0]]
                          : 'images/no-photo-available.png'"
                    cover
                    style="border-radius: 30px"
                ></v-img>
                <div style="height: 150px">
                  <v-card-title class="pa-1">{{project.title}}</v-card-title>
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

    <v-empty-state
        v-else
        icon="mdi-magnify"
        title="Aucun projet ne correspond à votre recherche."
        text="Essayez d'ajuster vos termes de recherche."
    ></v-empty-state>
  </div>
</template>

<style scoped>
.container{
  width: 90%;
  margin-left: 5%;
}
</style>