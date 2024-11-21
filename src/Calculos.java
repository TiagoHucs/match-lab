import java.util.List;

public abstract class Calculos {

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
        int pontosPosicaoTabela = switch (equipe.getPosicaoTabela()) {
            case 1, 2, 3 -> 25;
            case 4, 5, 6 -> 20;
            case 7, 8, 9 -> 15;
            case 10, 11, 12, 13, 14 -> 10;
            default -> 5;
        };

        int pontosVitorias = equipe.getVitorias() * 10;
        int pontosEmpates = equipe.getEmpates() * 5;
        int pontosDerrotas = equipe.getDerrotas() * -5;

        return pontosPosicaoTabela + pontosVitorias + pontosEmpates + pontosDerrotas;
    }

    public static double calcularLotaçaoEstadio(int capacidade, boolean timeCasa) {
        int publico = (int) (Math.random() * (100 - 30 + 1) + 30) * capacidade / 100;
        return timeCasa ? publico * 0.6 : publico * 0.4;
    }

    public static double calcularFatorSorte() {
        return Math.random() * 100;
    }
}

