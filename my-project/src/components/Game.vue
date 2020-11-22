<template>
  <div id="game">
    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand" href="#/home">Home</a>
      <h2>Informações sobre o jogo</h2>
      <a class="navbar-brand" href="#/games">Games</a>
    </nav>
    <table class="table table-dark">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Titulo</th>
          <th scope="col">Preço</th>
          <th scope="col">Numero de vendas</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{ game.titulo }}</td>
          <td>{{ game.preco }}</td>
          <td>{{ game.numeroDeVendas }}</td>
        </tr>
      </tbody>
    </table>
    <img width="1366" height="768" v-bind:src="game.imagem" />
  </div>
</template>

<script>
import GameService from "@/services/GameService.js";
export default {
  name: "Game",
  data() {
    return {
      game: [],
    };
  },
  created() {
    this.game = GameService.obterGame(GameService.getGameSelecionado())
      .then((response) => {
        this.game = response.data.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>
<style scoped>
div {
  background-color: black;
}
td {
  color: white;
}
</style>