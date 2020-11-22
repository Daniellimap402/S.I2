<template>
  <div id="games">
    <nav class="navbar navbar-dark bg-dark">
     <a class="navbar-brand" href="#/home">Home</a>
     <h2>Lista de jogos</h2>
     <a class="navbar-brand" href="#/games">Games</a>
    </nav>
    <table class="table table-hover table-dark">
      <tbody>
        <tr v-for="game in games" :key="game.id">
          <td>
           <a href="#/game">  <img v-bind:src="game.imagem" height="200" width="400" @click="selecionarGame(game.id)"/></a>
          </td>
          <td >{{ game.titulo }}</td>
          <td v-show="aparecer">{{game.preco}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import GameService from "@/services/GameService.js";
export default {
  data() {
    return {
      games: [],
      aparecer : false
    };
  },
  created() {
    GameService.listarGames()
      .then((response) => {
        this.games = response.data.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    selecionarGame(id) {
      GameService.selecionarGame(id)
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1 {
  background-color: black;
  color: white;
  font-family: Optima, sans-serif;
  text-align: center;
}
table {
  font-family: OCR A Std, monospace;
}
</style>
