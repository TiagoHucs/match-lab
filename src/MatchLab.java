import java.util.Arrays;
import java.util.List;

public class MatchLab {

    public static void main(String[] args) {

        // Criando equipes
        Equipe equipeA = new Equipe("Flamengo", geraTime(), 1, 10, 4, 1);
        Equipe equipeB = new Equipe("Cruzeiro", geraTime(), 1, 10, 4, 1);

        new Partida(equipeA, equipeB).iniciar();

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
    

}
