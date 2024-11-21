import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MatchLab {

    public static void main(String[] args) {
        // Criando jogadores

        
        // Criando equipes
        Equipe equipeA = new Equipe("Flamengo", geraTime(), 1, 10, 4, 1);
        Equipe equipeB = new Equipe("Cruzeiro", geraTime(), 1, 10, 4, 1);

        //Simulacao.simularJogo(equipeA, equipeB);

        Partida partida = new Partida(equipeA, equipeB, 20000);
        partida.iniciar();

    }
    
    private static List<Jogador> geraTime(){
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(new Jogador( "GK"));
        
        for(int i = 0; i < 2 ; i++){
            jogadores.add(new Jogador( "DF"));
        }

        for(int i = 0; i < 2 ; i++){
            jogadores.add(new Jogador( "MD"));
        }

        for(int i = 0; i < 2 ; i++){
            jogadores.add(new Jogador( "MC"));
        }

        for(int i = 0; i < 2 ; i++){
            jogadores.add(new Jogador( "MA"));
        }

        for(int i = 0; i < 2 ; i++){
            jogadores.add(new Jogador( "AT"));
        }
        
        return jogadores;
    }
    

}
