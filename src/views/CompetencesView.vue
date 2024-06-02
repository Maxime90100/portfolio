<script>
export default {
  name: 'CompetencesView',
  data:()=>({
    languages: [
      {name: 'HTML', path: 'images/languages/html.png'},
      {name: 'CSS', path: 'images/languages/css.png'},
      {name: 'JavaScript', path: 'images/languages/javascript.png'},
      {name: 'Java', path: 'images/languages/java.png'},
      {name: 'Python', path: 'images/languages/python.png'},
      {name: 'NodeJS', path: 'images/languages/nodejs.png'},
      {name: 'VueJS', path: 'images/languages/vuejs.png'},
      {name: 'Spring', path: 'images/languages/spring.png'},
      {name: 'MongoDB', path: 'images/languages/mongodb.png'},
      {name: 'MySQL', path: 'images/languages/mysql.png'},
      {name: 'PostgreSQL', path: 'images/languages/postgresql.png'},
      {name: 'InfluxDB', path: 'images/languages/influxdb.png'},
      {name: 'Arduino', path: 'images/languages/arduino.png'},
      {name: 'Docker', path: 'images/languages/docker.png'},
      {name: 'Git', path: 'images/languages/git.png'},
    ]
  })
}
</script>

<template>
  <div>
    <h1 class="text-primary">Mes compétences</h1>
    <v-card class="container pa-3">
      <div v-for="language in languages" style="text-align: center">
        <v-avatar
            :image="language.path"
            rounded="0"
        ></v-avatar>
        <v-list-item
            class="text-white"
            :title="language.name"
        ></v-list-item>
      </div>
    </v-card>
  </div>
</template>

<style scoped>
.container{
  gap: 20px;
  width: 50vw;
  margin-left: 25vw;
  border-radius: 30px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
@media (max-width: 1000px) {
  .container{
    width: 80vw;
    margin-left: 10vw;
  }
}
@media (max-width: 700px) {
  .container{
    gap: 0;
  }
}
</style>