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
  },
  methods: {
    goTo(path){
      this.$router.push(path);
    }
  }
};
</script>

<template>
  <div>
    <VideoHeader class="header" :video="videoPath">
      <template v-slot:default>
        <h1>Bienvenue sur mon Portfolio</h1>
        <p>Je suis <span id="myname">Maxime Théveneau</span>, Développeur Full-Stack</p>
        <p>Passionné par l'innovation et le développement informatique.</p>
        <br>
        <v-btn
            @click="goTo('/about')"
            text="me découvrir"
            append-icon="mdi-arrow-right"
        ></v-btn>
      </template>
    </VideoHeader>
  </div>
</template>

<style scoped>
.header{
  cursor: url("/images/cursor.cur"), auto;
}
p{
  color: #c1c1c1;
}
#myname{
  color: white;
  font-weight: bold;
}
</style>
