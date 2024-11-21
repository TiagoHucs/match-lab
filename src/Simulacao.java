import java.util.List;

public abstract class Simulacao {

    public static void simularJogo(Equipe equipeA, Equipe equipeB){

        String[] setor = {"GK", "DF", "MD", "MC", "MA", "AT"};

        int etapaA = 3;
        int etapaB = 2;

        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0 ; i < 10 ; i++){
            String vencedorDispta = Simulacao.simularJogada(equipeA, equipeA.getSetor(setor[etapaA]), equipeB, equipeB.getSetor(setor[etapaB]));
            etapaA = vencedorDispta.equals("A") ? etapaA + 1 : etapaA - 1;
            etapaB = vencedorDispta.equals("B") ? etapaB + 1 : etapaB - 1;

            if(etapaA > 5){
                System.out.println("GOL do " + equipeA.getNome());
                System.out.println("Nova saida de bola");
                etapaA = 2;
                etapaB = 3;
                scoreA ++;
            } else if (etapaB > 5) {
                System.out.println("GOL do " + equipeB.getNome());
                System.out.println("Nova saida de bola");
                etapaA = 3;
                etapaB = 2;
                scoreB ++;
            }
        }

        System.out.println(String.format("Fim de jogo %s %s x %s %s",equipeA.getNome(),scoreA, scoreB, equipeB.getNome()));

    }

    private static String simularJogada(Equipe equipeA, List<Jogador> setorA, Equipe equipeB, List<Jogador> setorB) {
        // Cálculos dos fatores
        double mediaForcaEquipeA = Calculos.calcularMediaForcaEquipe(equipeA) * 0.1;
        double mediaForcaSetorA = Calculos.calcularMediaForcaSetor(setorA) * 0.4;
        double moralA = Calculos.calcularMoralEquipe(equipeA) * 0.2;
        double lotacaoA = Calculos.calcularLotaçaoEstadio(100000, true) * 0.2;
        double sorteA = Calculos.calcularFatorSorte() * 0.1;

        double mediaForcaEquipeB = Calculos.calcularMediaForcaEquipe(equipeB) * 0.1;
        double mediaForcaSetorB = Calculos.calcularMediaForcaSetor(setorB) * 0.4;
        double moralB = Calculos.calcularMoralEquipe(equipeB) * 0.2;
        double lotacaoB = Calculos.calcularLotaçaoEstadio(100000, false) * 0.2;
        double sorteB = Calculos.calcularFatorSorte() * 0.1;

        // Soma dos fatores
        double totalA = mediaForcaEquipeA + mediaForcaSetorA + moralA + lotacaoA + sorteA;
        double totalB = mediaForcaEquipeB + mediaForcaSetorB + moralB + lotacaoB + sorteB;

        System.out.println(String.format("Disputa de bola Equipe: %s[%s] x [%s]%s ",
                equipeA.getNome(), setorA.get(0).getPosicao(),
                 setorB.get(0).getPosicao(), equipeB.getNome()));

        // Resultado
        if (totalA > totalB) {
            System.out.println(equipeA.getNome() + " venceu a disputa no setor " +setorA.get(0).getPosicao()+"! ");
            return "A";
        } else if (totalA < totalB) {
            System.out.println(equipeB.getNome() + " venceu a disputa no setor " +setorB.get(0).getPosicao()+"! ");
            return "B";
        }
        return null;
    }



}

