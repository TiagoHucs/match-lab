import java.util.List;

public class MatchLab {

    public static void main(String[] args) {
        // Criando jogadores

        Jogador j1 = new Jogador(Nomes.getRandomName(), 60, 80, "GK");
        Jogador j2 = new Jogador(Nomes.getRandomName(), 60, 80, "DF");
        Jogador j3 = new Jogador(Nomes.getRandomName(), 50, 75, "MD");
        Jogador j4 = new Jogador(Nomes.getRandomName(), 50, 75, "MC");
        Jogador j5 = new Jogador(Nomes.getRandomName(), 50, 75, "MA");
        Jogador j6 = new Jogador(Nomes.getRandomName(), 50, 75, "AT");

        Jogador j7 = new Jogador(Nomes.getRandomName(), 60, 80, "GK");
        Jogador j8 = new Jogador(Nomes.getRandomName(), 60, 80, "DF");
        Jogador j9 = new Jogador(Nomes.getRandomName(), 50, 75, "MD");
        Jogador j10 = new Jogador(Nomes.getRandomName(), 50, 75, "MC");
        Jogador j11 = new Jogador(Nomes.getRandomName(), 50, 75, "MA");
        Jogador j12 = new Jogador(Nomes.getRandomName(), 50, 75, "AT");

        // Criando equipes
        Equipe equipeA = new Equipe("Flamengo", List.of(j1, j2, j3, j4, j5, j6), 7, 10, 5, 3);
        Equipe equipeB = new Equipe("Vasco", List.of(j7, j8, j9, j10, j11, j12), 9, 8, 4, 6);



        Simulacao.simularJogo(equipeA, equipeB);

    }

}
