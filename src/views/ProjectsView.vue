<template>
  <div>
    <ProjectCards
        v-if="!$route.params.id"
        :projects="projects"
    ></ProjectCards>
    <ProjectDetails
      v-else
      :project="selectedProject"
    ></ProjectDetails>
  </div>
</template>

<script>
import ProjectCards from "@/components/projects/ProjectCards.vue";
import ProjectDetails from "@/components/projects/ProjectDetails.vue";

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
      try {
        const response = await fetch(`${import.meta.env.BASE_URL}public/data/projects.json`);
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        this.projects = await response.json();
      } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
      }
    }
  }
};
</script>