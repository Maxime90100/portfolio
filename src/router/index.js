import { createRouter, createWebHistory } from 'vue-router'
import HomeView from "@/views/HomeView.vue";
import ProjectsView from "@/views/ProjectsView.vue";
import ExperiencesView from "@/views/ExperiencesView.vue";
import EducationView from "@/views/EducationView.vue";
import CompetencesView from "@/views/CompetencesView.vue";
import AboutView from "@/views/AboutView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/projects/:id?',
      name: 'projects',
      component: ProjectsView
    },
    {
      path: '/experiences',
      name: 'experiences',
      component: ExperiencesView
    },
    {
      path: '/education',
      name: 'education',
      component: EducationView
    },
    {
      path: '/competences',
      name: 'competences',
      component: CompetencesView
    },
    {
      path: '/about',
      name: 'about',
      component: AboutView
    },
  ]
})

export default router
