import apiClient from "./ConfigService"

export default{
    gameSelecionado: null,
    listarGames(){
        return apiClient.get('/game')
    },
    obterGame(id)
    {
        return apiClient.get('/game/'+id)
    },
    selecionarGame(id)
    {
        this.gameSelecionado = id;
    },
    getGameSelecionado(){
        return this.gameSelecionado
    }
}