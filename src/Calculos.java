import java.util.List;
import java.util.Random;

public abstract class Calculos {

    private static Random random = new Random();

    public static double calcularMediaForcaEquipe(Equipe equipe) {
        return equipe.getJogadores().stream()
                .mapToInt(Jogador::getForca)
                .average()
                .orElse(0);
    }

    public static double calcularMediaForcaSetor(List<Jogador> jogadores) {
        return jogadores.stream()
                .mapToInt(Jogador::getForca)
                .average()
                .orElse(0);
    }

    public static double calcularMoralEquipe(Equipe equipe) {
        int qtdEquipes = 20;
        int pontosPorPosicao = qtdEquipes - equipe.getPosicaoTabela();
        int pontos = (equipe.getVitorias() * 3) + equipe.getEmpates();
        return pontosPorPosicao + pontos;
    }

    public static double calcularFatorSorte() {
        return Math.random() * 100;
    }

    public static double percentual(double parte,double total){
        return (parte / total) * 100;
    }

}

