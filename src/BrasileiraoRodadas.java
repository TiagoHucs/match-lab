import java.util.*;

public class BrasileiraoRodadas {

    public static void main(String[] args) {

        List<Equipe> equipes = geraTimes();
        List<Partida> partidas = RoundRobinFactory.gerarPartidas(equipes);

        for (Partida partida: partidas){
            partida.iniciar();
        }

        // Ordenando a lista por pontos (do menor para o maior)
        Collections.sort(equipes, Comparator.comparingInt(Equipe::getPontos).reversed());

        System.out.println("Tabela:");
        for(Equipe equipe: equipes){
            System.out.println(equipe.toString());
        }


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
        List<String> nomesTimes = List.of(Nomes.getTeamNames());
        List<Equipe> equipes = new ArrayList<>();
        for (String nome: nomesTimes){
            equipes.add(new Equipe(nome, geraTime(), 1, 0, 0, 0));
        }
        return equipes;
    }

}
