<template>
  <div id="app" class="container-fluid">
    <div class="site-info">
      <h1>Programação de computadores III</h1>
      <h3>Aula 17</h3>
    </div>
    <nav>
      <router-link class="btn btn-primary"
                   to="/">Cliente</router-link>
      <router-link class="btn btn-primary"
                   to="/add">Inserir</router-link>
      <router-link class="btn btn-primary"
                   to="/pesquisar">Pesquisar</router-link>
    </nav>
    <br/>
    <router-view/>
  </div>
</template>
<script>
export default {
  name: "app"
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}.btn-primary {
   margin-right: 5px;
 }
.container-fluid {
  text-align: center;
}
</style>