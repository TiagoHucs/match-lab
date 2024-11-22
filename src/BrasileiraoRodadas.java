import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BrasileiraoRodadas {

    public static void main(String[] args) {
        // Lista de equipes
        List<Equipe> equipes = geraTimes();

        // Gerar o calendário de rodadas
        List<List<Partida>> rodadas = gerarRodadas(equipes);

        // Exibir o calendário de rodadas
        int rodadaNum = 1;
        for (List<Partida> rodada : rodadas) {
            System.out.println("Rodada " + rodadaNum + ":");
            for (Partida jogo : rodada) {
                jogo.iniciar();
            }
            rodadaNum++;
        }

        System.out.println("Tabela:");
        for(Equipe equipe: equipes){
            System.out.println(String.format("%s Vitorias:%s Empates:%s Derrotas:%s ",
                    equipe.getNome(),equipe.getVitorias(),equipe.getEmpates(),equipe.getDerrotas()));
        }


    }

    public static List<List<Partida>> gerarRodadas(List<Equipe> equipes) {

        int totalRodadas = equipes.size() - 1; // Número de rodadas
        int jogosPorRodada = equipes.size() / 2; // Número de jogos por rodada

        // Lista para armazenar todas as rodadas
        List<List<Partida>> rodadas = new ArrayList<>();

        // Criar a lista rotativa de equipes (exceto a primeira)
        List<Equipe> rotacao = new ArrayList<>(equipes);
        Equipe fixa = rotacao.remove(0); // Primeira equipe é fixa

        for (int rodada = 0; rodada < totalRodadas; rodada++) {
            List<Partida> rodadaAtual = new ArrayList<>();

            // Criar os jogos da rodada
            rodadaAtual.add(new Partida(fixa,rotacao.get(0)));
            for (int i = 1; i < jogosPorRodada; i++) {
                Equipe casa = rotacao.get(i);
                Equipe visitante = rotacao.get(rotacao.size() - i);
                rodadaAtual.add(new Partida(casa,visitante));
            }

            // Adicionar a rodada à lista de rodadas
            rodadas.add(rodadaAtual);

            // Rotacionar as equipes (mantendo a fixa no lugar)
            Collections.rotate(rotacao, 1);
        }

        return rodadas;
    }


    private static List<Jogador> geraTime(){
        return Arrays.asList(
                new Jogador(50, 50, "GK"),
                new Jogador(50, 50, "DF"),
                new Jogador(50, 50, "DF"),
                new Jogador(50, 50, "MD"),
                new Jogador(50, 50, "MD"),
                new Jogador(50, 50, "MC"),
                new Jogador(50, 50, "MC"),
                new Jogador(50, 50, "MA"),
                new Jogador(50, 50, "MA"),
                new Jogador(50, 50, "AT"),
                new Jogador(50, 50, "AT")
        );
    }

    private static List<Equipe> geraTimes(){
        List<String> nomesTimes = Arrays.asList("Flamengo","Palmeiras","Corinthians","Fluminense","São Paulo","Grêmio");
        List<Equipe> equipes = new ArrayList<>();
        for (String nome: nomesTimes){
            equipes.add(new Equipe(nome, geraTime(), 1, 0, 0, 0));
        }
        return equipes;
    }

}
