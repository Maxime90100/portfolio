<script>
export default {
  name: 'AboutView',
  methods:{
    goTo(path){
      this.$router.push(path);
    }
  }
}
</script>

<template>
  <div class="container">
    <div class="avatar">
      <v-avatar image="images/me.jpeg" size="20vw"></v-avatar>
      <v-list-item
          class="text-white"
          title="Maxime Théveneau"
          subtitle="Etudiant développeur informatique"
      ></v-list-item>
    </div>
    <div class="content">
      <h2>Bienvenue sur mon Portfolio !</h2><br>
      <p>
        Je m'appelle Maxime et je suis étudiant en développement informatique passionné par les technologies et l'innovation. Actuellement en 3ème année de BUT Informatique à l'IUT de Belfort, je me spécialise dans le développement de logiciels et la création d'applications web et mobiles.
      </p>
      <br>
      <h3>Venez me découvrir :</h3>
      <v-btn prepend-icon="mdi-arrow-right" variant="plain" color="primary" @click="goTo('/projects')">Mes projets</v-btn>
      <v-btn prepend-icon="mdi-arrow-right" variant="plain" color="primary" @click="goTo('/experiences')">Mon expérience</v-btn>
      <v-btn prepend-icon="mdi-arrow-right" variant="plain" color="primary" @click="goTo('/competences')">Mes compétences</v-btn>
      <br><br>
      <v-btn
          prepend-icon="mdi-email"
          variant="text"
          density="compact"
          color="grey"
          text="maxime.theveneau@gmail.com"
          href="mailto:maxime.theveneau@gmail.com?subject=Contact from Portfolio&body=Bonjour%20Maxime,%0D%0A%0D%0A%0D%0A"
      ></v-btn><br>
      <a href="files/CV_THEVENEAU_Maxime.pdf" download="CV_THEVENEAU_Maxime.pdf">
        <v-btn
            prepend-icon="mdi-file-document"
            variant="text"
            density="compact"
            color="grey"
            text="CV"
        ></v-btn>
      </a><br>
      <v-btn
          prepend-icon="mdi-linkedin"
          variant="text"
          density="compact"
          color="#126BC4"
          text="Linkedin"
          href="https://www.linkedin.com/in/maxime-theveneau-401462219/"
          target="_blank"
      ></v-btn><br>
      <v-btn
          prepend-icon="mdi-github"
          variant="text"
          density="compact"
          color="#6F6EF1"
          text="Github"
          href="https://github.com/Maxime90100"
          target="_blank"
      ></v-btn>
    </div>
  </div>
</template>

<style scoped>
.container {
  height: 90vh;
  display: flex;
}

.avatar {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  width: 40%;
}

.content {
  padding-right: 10%;
  align-content: center;
  text-align: justify;
  width: 60%;
}
@media (max-width: 1100px) {
  .container {
    display: block;
    padding: 50px;
  }
  .avatar{
    width: 100%;
  }
  .content{
    width: 100%;
    text-align: center;
    padding-right: 0;
    margin-top: 20px;
  }
}
@media (max-width: 500px) {
  .container {
    padding: 10px;
  }
}
</style>
