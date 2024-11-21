import java.util.List;

public class MatchLab {

    public static void main(String[] args) {
        // Criando jogadores

        int forca = 50;

        Jogador j1 = new Jogador(Nomes.getRandomName(), 50, 50, "GK");
        Jogador j2 = new Jogador(Nomes.getRandomName(), 50, 50, "DF");
        Jogador j3 = new Jogador(Nomes.getRandomName(), 50, 50, "MD");
        Jogador j4 = new Jogador(Nomes.getRandomName(), 50, 50, "MC");
        Jogador j5 = new Jogador(Nomes.getRandomName(), 50, 50, "MA");
        Jogador j6 = new Jogador(Nomes.getRandomName(), 50, 50, "AT");

        // Criando equipes
        Equipe equipeA = new Equipe("Flamengo", List.of(j1, j2, j3, j4, j5, j6), 1, 10, 4, 1);
        Equipe equipeB = new Equipe("Cruzeiro", List.of(j1, j2, j3, j4, j5, j6), 1, 10, 4, 1);

        //Simulacao.simularJogo(equipeA, equipeB);

        Partida partida = new Partida(equipeA, equipeB, 20000);
        partida.iniciar();

    }

}
