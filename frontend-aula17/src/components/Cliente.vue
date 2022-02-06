<template>
  <div v-if="this.cliente">
    <h4>Cliente</h4>
    <div>
      <label>Nome: </label> {{this.cliente.nome}}
    </div>
    <div>
      <label>Idade: </label> {{this.cliente.idade}}
    </div>
    <div><label>Ativo: </label> {{this.cliente.ativo}}
    </div>
    <button v-if="this.cliente.ativo"
            v-on:click="updateAtivo(false)"
            class="button is-small btn-primary">Inativo</button>
    <button v-else
            v-on:click="updateAtivo(true)"
            class="button is-small btn-primary">Ativo</button>
    <button class="button is-small btn-danger"
            v-on:click="deleteCliente()">Delete</button>
  </div>
  <div v-else>
    <br/>
    <p>Clique em um cliente...</p>
  </div>
</template>
<script>
import http from "../http-common";
export default {
  name: "cliente",
  props: ["cliente"],
  methods: {
    updateAtivo(status) {
      var data = {
        id: this.cliente.id,
        nome: this.cliente.nome,
        idade: this.cliente.idade,
        ativo: status
      };
      http
          .put("/cliente/" + this.cliente.id, data)
          .then(response => {this.cliente.ativo = response.data.ativo;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },
    deleteCliente() {
      http
          .delete("/cliente/" + this.cliente.id)
          .then(response => {
            console.log(response.data);
            this.$emit("refreshData");
            this.$router.push('/');
          })
          .catch(e => {
            console.log(e);
          });
    }
  }
};
</script>