<script>
import ProjectCards from "@/components/projects/ProjectCards.vue";
import ProjectDetails from "@/components/projects/ProjectDetails.vue";
import {getAllProjects} from "@/services/projects.service.js";

export default {
  name: 'ProjectsView',
  components: {ProjectDetails, ProjectCards},
  data() {
    return {
      projects: []
    };
  },
  mounted() {
    this.loadProjects();
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
    scrollToTop() {
      window.scrollTo({ top: 0 });
    }
  },
  watch: {
    $route(to, from) {
      this.scrollToTop();
    }
  }
};
</script>

<template>
  <div>
    <h1 class="text-primary">Mes projets</h1>
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

<style scoped>

</style>