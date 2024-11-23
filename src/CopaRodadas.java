import java.util.*;

public class CopaRodadas {

    public static void main(String[] args) {

        List<Equipe> equipes = geraTimes();

        System.out.println("Oitavas de final");
        Equipe vencedorA1 = new Partida(equipes.get(0),equipes.get(1)).iniciar();
        Equipe vencedorA2 = new Partida(equipes.get(2),equipes.get(3)).iniciar();
        Equipe vencedorA3 = new Partida(equipes.get(4),equipes.get(5)).iniciar();
        Equipe vencedorA4 = new Partida(equipes.get(6),equipes.get(7)).iniciar();
        Equipe vencedorA5 = new Partida(equipes.get(8),equipes.get(9)).iniciar();
        Equipe vencedorA6 = new Partida(equipes.get(10),equipes.get(11)).iniciar();
        Equipe vencedorA7 = new Partida(equipes.get(12),equipes.get(13)).iniciar();
        Equipe vencedorA8 = new Partida(equipes.get(14),equipes.get(15)).iniciar();

        System.out.println("Quartas de final");
        Equipe vencedorB1 = new Partida(vencedorA1,vencedorA5).iniciar();
        Equipe vencedorB2 = new Partida(vencedorA2,vencedorA6).iniciar();
        Equipe vencedorB3 = new Partida(vencedorA3,vencedorA7).iniciar();
        Equipe vencedorB4 = new Partida(vencedorA4,vencedorA8).iniciar();

        System.out.println("Semi-final");
        Equipe vencedorC1 = new Partida(vencedorB1,vencedorB3).iniciar();
        Equipe vencedorC2 = new Partida(vencedorB2,vencedorB4).iniciar();

        System.out.println("Final");
        Equipe campea = new Partida(vencedorC1,vencedorC2).iniciar();


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
