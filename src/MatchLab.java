import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchLab {

    public static void main(String[] args) {

        List<Equipe> equipes = geraTimes();


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
