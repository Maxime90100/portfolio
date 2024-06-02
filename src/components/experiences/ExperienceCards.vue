<script>
export default {
  name: 'ExperienceCards',
  props: ['experiences'],
  data() {
    return {
      windowWidth: window.innerWidth
    };
  },
  methods: {
    goTo(path) {
      this.$router.push(path);
    },
    handleResize() {
      this.windowWidth = window.innerWidth;
    }
  },
  computed: {
    isMobile() {
      return this.windowWidth < 1000;
    }
  },
  mounted() {
    window.addEventListener('resize', this.handleResize);
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.handleResize);
  }
}
</script>

<template>
  <v-timeline
      class="container"
      :side="isMobile ? 'end' : ''"
  >
    <v-timeline-item
        v-for="experience in experiences"
        :key="experience.id"
        :size="isMobile ? 'small' : 'large'"
    >
      <template v-slot:icon>
        <v-avatar
            :size="isMobile ? 'small' : 'large'"
            :image="experience.place.logo"
            color="background"
        ></v-avatar>
      </template>
      <template v-slot:opposite v-if="!isMobile">
        <div class="pt-1 headline font-weight-bold">{{ experience.startTime }} - {{ experience.endTime }}</div>
      </template>
      <v-card :class="{ 'mobile-card': isMobile }" style="border-radius: 30px">
        <v-card-title class="text-h5">{{ experience.title }}</v-card-title>
        <v-card-subtitle v-if="isMobile" class="mb-4">{{ experience.startTime }} - {{ experience.endTime }}</v-card-subtitle>
        <v-card-subtitle>{{ experience.place.name }}</v-card-subtitle>
        <v-card-actions>
          <v-btn
              @click="goTo('/experiences/' + experience.id)"
              color="primary"
              text
              append-icon="mdi-plus"
          >Voir</v-btn>
        </v-card-actions>
      </v-card>
    </v-timeline-item>
  </v-timeline>
</template>

<style scoped>
.container {
  width: 90vw;
  margin-left: 5vw;
}
.mobile-card {
  width: 65vw;
}
.mobile-card > * {
  white-space: normal;
  word-wrap: break-word;
}
</style>
