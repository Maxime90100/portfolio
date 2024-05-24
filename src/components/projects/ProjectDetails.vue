<script>
export default {
  name:'ProjectDetails',
  props:['project'],
  computed: {
    baseUrl() {
      return import.meta.env.BASE_URL
    },
  },
  data() {
    return {
      dialog: false,
      selectedImage: ''
    }
  },
  methods: {
    openDialog(index) {
      this.selectedImage = this.baseUrl + this.project.images[index];
      this.dialog = true;
    },
    closeDialog() {
      this.dialog = false;
      this.selectedImage = '';
    }
  }
}
</script>

<template>
  <v-container v-if="project">

    <v-row>
      <router-link to="/projects" class="ml-3"><v-btn icon="mdi-arrow-left"></v-btn></router-link>
      <h1 class="text-primary ml-4">{{project.title}}</h1>
    </v-row>

    <v-row v-if="project.body" v-for="section of project.body">
      <v-col cols="12">
        <v-card>
          <v-card-title class="text-h5">{{section.title}}</v-card-title>
          <v-card-text style="white-space: pre-line;">{{section.description}}</v-card-text>
        </v-card>
      </v-col>
    </v-row>

    <v-row v-if="project.competences && project.competences.length > 0">
      <v-col>
        <v-card color="primary">
          <v-card-title class="text-h5">Compétences</v-card-title>
          <v-card-text style="white-space: pre-line;">
            <v-chip-group>
              <v-chip v-for="competence of project.competences">{{competence}}</v-chip>
            </v-chip-group>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>

    <v-row v-if="project.images">
      <v-col cols="4" v-for="(img, key) of Object.entries(project.images)" :key="key">
        <v-card @click="openDialog(img[0])">
          <v-card-title>{{ img[0] }}</v-card-title>
          <v-img class="align-end text-white" :src="baseUrl + img[1]" cover></v-img>
        </v-card>
      </v-col>
      <v-dialog v-model="dialog" max-width="75%">
        <v-card class="pa-4">
          <v-img :src="selectedImage">
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="error" icon="mdi-close" variant="elevated" @click="closeDialog"></v-btn>
            </v-card-actions>
          </v-img>
        </v-card>
      </v-dialog>
    </v-row>

    <v-row v-if="project.files">
      <v-col cols="12">
        <v-list>
          <v-list-item v-for="(file, key) of Object.entries(project.files)" :key="key">
            <a :href="baseUrl + file[1]" :download="file[0]">
              <v-btn prepend-icon="mdi-download" :text="file[0]" variant="plain"></v-btn>
            </a>
          </v-list-item>
        </v-list>
      </v-col>
    </v-row>

  </v-container>
</template>