public class Partida {

    private static final String[] SETORES = {"GK", "DF", "MD", "MC", "MA", "AT", "AT"};
    private static final int SETOR_INICIAL = 3;
    private static final int DURACAO_JOGO = 45;

    private static int setor = SETOR_INICIAL;

    private static int scoreA = 0;
    private static int scoreB = 0;

    Equipe casa;
    Equipe visitante;

    int publico;
    int publicoCasa;
    int publicoVisitante;

    double moralCasa;
    double moralVisitante;

    public Partida(Equipe casa, Equipe visitante, int capadidadeEstadio) {
        this.casa = casa;
        this.visitante = visitante;
        this.publico = (int) (Math.random() * (100 - 30 + 1) + 30) * capadidadeEstadio / 100;
        this.publicoCasa = (int) (publico * 0.6);
        this.publicoVisitante = (int) (publico * 0.4);

        this.moralCasa = Calculos.calcularMoralEquipe(casa) * 0.2;
        this.moralVisitante = Calculos.calcularMoralEquipe(visitante) * 0.2;
    }

    /**
     * setores     X  0   1   2   3   4   5   6   X
     * casa        X  GK  DF  MD  MC  MA  AT  AT  X
     * visitante   X  AT  AT  MA  MC  MD  DF  GK  X
     *
     * @return
     */
    public void iniciar() {

        for (int i = 0; i < DURACAO_JOGO; i++) {
            Graficos.printField2(setor);
            // Simula a jogada e obtém o vencedor
            Equipe vencedorDisputa = disputa(setor);

            // Atualiza setor com base no vencedor
            if (vencedorDisputa.equals(casa)) {
                setor++;
            } else {
                setor--;
            }

            // Verifica se algum time marcou gol
            if (setor > 6) {
                scoreA++;
                System.out.println("GOL do " + casa.getNome() + "! Nova saída de bola.");
                setor = SETOR_INICIAL;
            } else if (setor < 0) {
                scoreB++;
                System.out.println("GOL do " + visitante.getNome() + "! Nova saída de bola.");
                setor = SETOR_INICIAL;
            }

        }

        // Resultado final
        System.out.printf("Fim de jogo %s %d x %d %s%n", casa.getNome(), scoreA, scoreB, visitante.getNome());
    }

    private Equipe disputa(int setorCasa) {

        int setorVisitante = 6 - setorCasa;

        double mediaForcaCasa = Calculos.calcularMediaForcaEquipe(casa) * 0.1;
        double mediaForcaSetorCasa = Calculos.calcularMediaForcaSetor(casa.getSetor(SETORES[setorCasa])) * 0.4;
        double sorteA = Calculos.calcularFatorSorte() * 0.1;

        double mediaForcaVisitante = Calculos.calcularMediaForcaEquipe(visitante) * 0.1;
        double mediaForcaSetorVisitante = Calculos.calcularMediaForcaSetor(casa.getSetor(SETORES[setorVisitante])) * 0.4;
        double sorteB = Calculos.calcularFatorSorte() * 0.1;

        // Soma dos fatores
        double totalCasa = mediaForcaCasa + mediaForcaSetorCasa + moralCasa + publicoCasa + sorteA;
        double totalVisit = mediaForcaVisitante + mediaForcaSetorVisitante + moralVisitante + publicoVisitante + sorteB;

        if (totalCasa >= totalVisit) {
            return casa;
        }
        return visitante;

    }
}
