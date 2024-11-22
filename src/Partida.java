public class Partida {

    private static final String[] SETORES = {"GK", "DF", "MD", "MC", "MA", "AT", "AT"};
    private static final int SETOR_INICIAL = 3;
    private static final int DURACAO_JOGO = 45;

    private static int setor = SETOR_INICIAL;

    private int tempo = 0;
    private int scoreA = 0;
    private int scoreB = 0;

    private Equipe equipePosse;
    private Equipe casa;
    private Equipe visi;

    private double moralCasa;
    private double moralVisi;

    public Partida(Equipe casa, Equipe visitante) {
        this.casa = casa;
        this.visi = visitante;

        this.moralCasa = Calculos.calcularMoralEquipe(casa);
        this.moralVisi = Calculos.calcularMoralEquipe(visitante);
    }

    /**
     * setores     X  0   1   2   3   4   5   6   X
     * casa        X  GK  DF  MD  MC  MA  AT  AT  X
     * visitante   X  AT  AT  MA  MC  MD  DF  GK  X
     *
     * @return
     */
    public void iniciar() {

        equipePosse = casa;

        while (tempo <= DURACAO_JOGO) {
            Graficos.printField(setor);

            // Simula a jogada e obtém o vencedor
            Equipe vencedorDisputa = disputa(tempo,equipePosse, setor);
            equipePosse = vencedorDisputa;

            // Atualiza setor com base no vencedor
            if(equipePosse.equals(vencedorDisputa)){
                avancaSetor(vencedorDisputa);
            }

            // Verifica se algum time marcou gol
            processarGol(setor, tempo, casa, visi);

            tempo++;
            Utils.aguarda();
        }

        // Resultado final
        Narracao.narrar(tempo, String.format("Fim de jogo %s %d x %d %s%n", casa.getNome(), scoreA, scoreB, visi.getNome()));
    }

    private void avancaSetor(Equipe vencedorDisputa) {
        setor = vencedorDisputa.equals(casa) ? setor + 1 : setor -1;
    }

    private Equipe disputa(int tempo, Equipe posse , int setorCasa) {

        int setorVisi = 6 - setorCasa;

        double mediaForcaCasa = Calculos.calcularMediaForcaEquipe(casa) * 0.1;
        double mediaForcaVisi = Calculos.calcularMediaForcaEquipe(visi) * 0.1;

        double mediaForcaSetorCasa = Calculos.calcularMediaForcaSetor(casa.getSetor(SETORES[setorCasa])) * 0.4;
        double mediaForcaSetorVisi = Calculos.calcularMediaForcaSetor(casa.getSetor(SETORES[setorVisi])) * 0.4;

        // Soma dos fatores
        double totalCasa = mediaForcaCasa + mediaForcaSetorCasa + moralCasa;
        double totalVisi = mediaForcaVisi + mediaForcaSetorVisi + moralVisi;

        double chanceCasa = Calculos.percentual(totalCasa,totalCasa + totalVisi);

        double sorte = Calculos.calcularFatorSorte();
        Equipe vencedorDisputa = chanceCasa >= sorte ? casa : visi;
        String lance = posse.equals(vencedorDisputa) ? " avança " : " rouba a bola ";
        Narracao.narrar(tempo,vencedorDisputa.getNome() + lance);
        return vencedorDisputa;
    }

    private void processarGol(int setor, int tempo, Equipe casa, Equipe visi) {
        if (setor > 6) {
            marcarGol(casa, tempo, visi);
        } else if (setor < 0) {
            marcarGol(visi, tempo, casa);
        }
    }

    private void marcarGol(Equipe equipeMarcadora, int tempo, Equipe adversario) {
        if (equipeMarcadora == casa) {
            scoreA++;
        } else {
            scoreB++;
        }
        Graficos.printField(setor);
        Narracao.narrar(tempo, "GOOOOOL do " + equipeMarcadora.getNome());
        setor = SETOR_INICIAL;
        equipePosse = adversario;
    }
}
