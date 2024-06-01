<script>
import ExperienceCards from "@/components/experiences/ExperienceCards.vue";
import ExperienceDetails from "@/components/experiences/ExperienceDetails.vue";
import {getAllExperiences} from "@/services/projects.service.js";

export default {
  name: 'ExperiencesView',
  components: {ExperienceDetails, ExperienceCards},
  data() {
    return {
      experiences: []
    };
  },
  mounted() {
    this.loadExperiences();
  },
  computed:{
    selectedExperience() {
      const experienceId = parseInt(this.$route.params.id);
      return experienceId
          ? this.experiences.find(e => e.id === experienceId)
          : null
    }
  },
  methods: {
    async loadExperiences() {
      getAllExperiences()
          .then(experiences => this.experiences = experiences)
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
    <h1 class="text-primary">Mon expérience</h1>
    <ExperienceCards
        v-if="!$route.params.id"
        :experiences="experiences"
    ></ExperienceCards>
    <div v-else>
      <ExperienceDetails
          v-if="selectedExperience"
          :experience="selectedExperience"
      ></ExperienceDetails>
      <v-empty-state
          v-else
          icon="mdi-magnify"
          title="Aucune expérience ne correspond à votre recherche."
          text="Essayez d'ajuster vos termes de recherche."
      >
        <router-link to="/experiences"><v-btn icon="mdi-arrow-left"></v-btn></router-link>
      </v-empty-state>
    </div>
  </div>
</template>

<style scoped>

</style>