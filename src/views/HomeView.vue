<script>
import VideoHeader from "@/components/VideoHeader.vue";

export default {
  name: 'HomeView',
  components: {
    VideoHeader
  },
  computed: {
    videoPath() {
      return import.meta.env.BASE_URL + 'videos/homepage_background.mp4';
    }
  }
};
</script>

<template>
  <div>
    <VideoHeader :video="videoPath">
      <template v-slot:default>
        <h1>Bienvenue sur mon Portfolio</h1>
        <p>Je suis Maxime Théveneau, Développeur Full-Stack</p>
        <p>Passionné par la création d'applications web et mobiles innovantes.</p>
        <v-btn>me découvrir</v-btn>
      </template>
    </VideoHeader>
  </div>
</template>

<style scoped>

</style>
