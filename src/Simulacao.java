import java.util.List;

public abstract class Simulacao {

    public static void simularJogo(Equipe equipeA, Equipe equipeB){
        Simulacao.simularJogada(equipeA, equipeA.getSetor("MA"), equipeB, equipeB.getSetor("MD"));
    }

    private static void simularJogada(Equipe equipeA, List<Jogador> setorA, Equipe equipeB, List<Jogador> setorB) {
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

        // Resultado
        if (totalA > totalB) {
            System.out.print(equipeA.getNome() + " venceu a disputa no setor " +setorA.get(0).getPosicao()+"! ");
        } else if (totalA < totalB) {
            System.out.print(equipeB.getNome() + " venceu a disputa no setor " +setorB.get(0).getPosicao()+"! ");
        } else {
            System.out.println("Empate na disputa! ");
        }
        System.out.println((int) totalA + " x " + (int) totalB);
    }



}

