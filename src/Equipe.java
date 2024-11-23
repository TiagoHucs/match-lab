import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Jogador> jogadores;
    private int posicaoTabela;
    private int vitorias;
    private int empates;
    private int derrotas;

    public Equipe(String nome, List<Jogador> jogadores, int posicaoTabela, int vitorias, int empates, int derrotas) {
        this.nome = nome;
        this.jogadores = jogadores;
        this.posicaoTabela = posicaoTabela;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public int getPosicaoTabela() {
        return posicaoTabela;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public String getNome() {
        return nome;
    }

    public List<Jogador> getSetor(String setor){
        List<Jogador> jogadoressetor = new ArrayList<>();
        for(Jogador j : jogadores){
            if(setor.equals(j.getPosicao())){
                jogadoressetor.add(j);
            }
        }
        return jogadoressetor;
    }

    public void addVitoria(){
        this.vitorias++;
    }

    public void addEmpate(){
        this.empates++;
    }

    public void addDerrota(){
        this.derrotas++;
    }

    int getPontos(){
        return (vitorias * 3) + empates;
    }

    public String toString(){
        return (String.format("%-15s Pontos:%s Vitorias:%s Empates:%s Derrotas:%s ",nome,getPontos(),vitorias,empates,derrotas));
    }
}

