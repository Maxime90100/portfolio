<template>
  <div>
    <ProjectCards
        v-if="!$route.params.id"
        :projects="projects"
    ></ProjectCards>
    <div v-else>
      <ProjectDetails
          v-if="selectedProject"
          :project="selectedProject"
      ></ProjectDetails>
      <v-empty-state
          v-else
          icon="mdi-magnify"
          title="Aucun projet ne correspond à votre recherche."
          text="Essayez d'ajuster vos termes de recherche."
      >
        <router-link to="/projects"><v-btn icon="mdi-arrow-left"></v-btn></router-link>
      </v-empty-state>
    </div>
  </div>
</template>

<script>
import ProjectCards from "@/components/projects/ProjectCards.vue";
import ProjectDetails from "@/components/projects/ProjectDetails.vue";
import {getAllProjects, getProjectsTags} from "@/services/projects.service.js";

export default {
  name: 'ProjectsView',
  components: {ProjectDetails, ProjectCards},
  data() {
    return {
      projects: [],
      tags: []
    };
  },
  mounted() {
    this.loadProjects();
    this.loadTags()
  },
  computed:{
    selectedProject() {
      const projectId = parseInt(this.$route.params.id);
      return projectId
          ? this.projects.find(p => p.id === projectId)
          : null
    }
  },
  methods: {
    async loadProjects() {
      getAllProjects()
          .then(projects => this.projects = projects)
          .catch(error => console.error(error))
    },
    async loadTags(){
      getProjectsTags()
          .then(tags => this.tags = tags)
          .catch(error => console.error(error))
    }
  }
};
</script>