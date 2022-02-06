import Vue from "vue";
import Router from "vue-router";
import ListaClientes from "./components/ListaClientes.vue";
import AddCliente from "./components/AddCliente.vue";
import PesquisarCliente from "./components/PesquisarCliente.vue";
import Cliente from "./components/Cliente.vue";
Vue.use(Router);
export default new Router({
    mode: "history",
    routes: [
        {
            path: "/",
            name: "clientes",
            alias: "/cliente",
            component: ListaClientes,
            children: [
                {
                    path: "/cliente/:id",
                    name: "cliente-detalhes",
                    component: Cliente,
                    props: true
                }
            ]
        },
        {
            path: "/add",
            name: "add",
            component: AddCliente
        },
        {
            path: "/pesquisar",
            name: "pesquisar",
            component: PesquisarCliente
        }]
});