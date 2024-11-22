public class Partida {

    private static final String[] SETORES = {"GK", "DF", "MD", "MC", "MA", "AT", "AT"};
    private static final int SETOR_INICIAL = 3;
    private static final int DURACAO_JOGO = 90;

    private static int setor = SETOR_INICIAL;

    private static int scoreA = 0;
    private static int scoreB = 0;

    Equipe casa;
    Equipe visi;

    int publico;
    int publicoCasa;
    int publicoVisi;

    double moralCasa;
    double moralVisi;

    public Partida(Equipe casa, Equipe visitante, int capadidadeEstadio) {
        this.casa = casa;
        this.visi = visitante;
        this.publico = (int) (Math.random() * (100 - 30 + 1) + 30) * capadidadeEstadio / 100;
        this.publicoCasa = (int) (publico * 0.6);
        this.publicoVisi = (int) (publico * 0.4);

        this.moralCasa = Calculos.calcularMoralEquipe(casa) * 0.2;
        this.moralVisi = Calculos.calcularMoralEquipe(visitante) * 0.2;
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
            Graficos.printField(setor);
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
                System.out.println("GOL do " + visi.getNome() + "! Nova saída de bola.");
                setor = SETOR_INICIAL;
            }

        }

        // Resultado final
        System.out.printf("Fim de jogo %s %d x %d %s%n", casa.getNome(), scoreA, scoreB, visi.getNome());
    }

    private Equipe disputa(int setorCasa) {

        int setorVisi = 6 - setorCasa;

        double mediaForcaCasa = Calculos.calcularMediaForcaEquipe(casa) * 0.1;
        double mediaForcaVisi = Calculos.calcularMediaForcaEquipe(visi) * 0.1;

        double mediaForcaSetorCasa = Calculos.calcularMediaForcaSetor(casa.getSetor(SETORES[setorCasa])) * 0.4;
        double mediaForcaSetorVisi = Calculos.calcularMediaForcaSetor(casa.getSetor(SETORES[setorVisi])) * 0.4;

        double sorteCasa = Calculos.calcularFatorSorte() * 0.1;
        double sorteVisi = Calculos.calcularFatorSorte() * 0.1;

        // Soma dos fatores
        double totalCasa = mediaForcaCasa + mediaForcaSetorCasa + moralCasa + sorteCasa;
        double totalVisi = mediaForcaVisi + mediaForcaSetorVisi + moralVisi + sorteVisi;

        double total = totalCasa + totalVisi;

        double percentCasa = (totalCasa / total) * 100;
        double percentVisi = (totalVisi / total) * 100;

        if (totalCasa >= totalVisi) {
            return casa;
        }
        return visi;

    }
}
