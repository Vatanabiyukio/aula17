<template>
  <div class="submitform">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="nome">Nome</label>
        <input type="text" class="form-control" id="nome" required
               v-model="cliente.nome" name="nome">
      </div>
      <div class="form-group">
        <label for="idade">Idade</label>
        <input type="number" class="form-control" id="idade" required
               v-model="cliente.idade" name="idade">
      </div>
      <button v-on:click="salvarCliente" class="btn
btn-success">Salvar</button>
    </div>
    <div v-else>
      <h4>Salvo com sucesso.</h4>
      <button class="btn btn-success" v-on:click="novoCliente">Adicionar</button>
    </div>
  </div>
</template>
<script>
import http from "../http-common";
export default {
  name: "add-cliente",
  data() {
    return {
      cliente: {
        id: 0,
        nome: "",
        idade: 0,
        ativo: false
      },
      submitted: false
    };
  },
  methods: {
    salvarCliente() {
      var data = {
        nome: this.cliente.nome,
        idade: this.cliente.idade
      };
      http
          .post("/cliente", data)
          .then(response => {
            this.cliente.id = response.data.id;
            console.log(response.data);
          })
          .catch(e => {console.log(e);
          });
      this.submitted = true;
    },
    novoCliente() {
      this.submitted = false;
      this.cliente = {};
    }
  }
};
</script>
<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
</style>