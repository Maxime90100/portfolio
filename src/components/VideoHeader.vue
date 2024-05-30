<script>
export default {
  name: 'VideoHeader',
  props: ['video']
};
</script>

<template>
  <header>
    <div class="overlay"></div>
    <video autoplay muted loop class="background-video">
      <source :src="video" type="video/mp4">
      Votre navigateur ne supporte pas les vidéos HTML5.
    </video>
    <div class="header-content">
      <slot></slot>
    </div>
  </header>
</template>

<style scoped>
header {
  position: relative;
  height: 92vh;
  width: 100%;
  overflow: hidden;
}

.background-video {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 100%;
  height: 100%;
  object-fit: cover;
  transform: translate(-50%, -50%);
  z-index: 1;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.6);
  z-index: 2;
}

.header-content {
  position: relative;
  z-index: 3;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
  text-align: center;
  color: #fff;
  padding: 0 20px;
  font-size: clamp(1rem, 4vw, 2rem);
}
</style>