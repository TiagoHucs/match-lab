import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RoundRobinFactory {


        public static List<Partida> gerarPartidas(List<Equipe> equipes) {
            List<Partida> partidas = new ArrayList<>();
            int totalEquipes = equipes.size();

            // Se o número de equipes for ímpar, adicionar uma equipe "folga"
            if (totalEquipes % 2 != 0) {
                equipes.add(new Equipe("Folga",null,0,0,0,0));
                totalEquipes++;
            }

            int rodadas = totalEquipes - 1; // Cada equipe enfrenta todas as outras uma vez
            int jogosPorRodada = totalEquipes / 2;

            // Copiar a lista para não alterar a original
            List<Equipe> equipesRotativas = new ArrayList<>(equipes);

            for (int rodada = 0; rodada < rodadas; rodada++) {
                for (int jogo = 0; jogo < jogosPorRodada; jogo++) {
                    Equipe equipeCasa = equipesRotativas.get(jogo);
                    Equipe equipeVisitante = equipesRotativas.get(totalEquipes - 1 - jogo);

                    if (!equipeCasa.getNome().equals("Folga") && !equipeVisitante.getNome().equals("Folga")) {
                        partidas.add(new Partida(equipeCasa, equipeVisitante));
                    }
                }

                // Rotacionar as equipes (fixando a primeira)
                Collections.rotate(equipesRotativas.subList(1, equipesRotativas.size()), 1);
            }

            // Gerar o returno (invertendo os mandos de campo)
            List<Partida> partidasReturno = new ArrayList<>();
            for (Partida partida : partidas) {
                partidasReturno.add(new Partida(partida.getEquipeVititante(), partida.getEquipeCasa()));
            }

            // Adicionar o returno ao final da lista
            partidas.addAll(partidasReturno);

            return partidas;
        }

    }
