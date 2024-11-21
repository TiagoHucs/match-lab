import java.util.Random;

public class Jogador {
    private String nome;
    private int forca;
    private int precisao;
    private String posicao;

    public Jogador(String posicao) {
        this.nome = Nomes.getRandomName();
        this.forca = getRand();
        this.precisao = getRand();
        this.posicao = posicao;
    }

    public int getForca() {
        return forca;
    }

    public int getPrecisao() {
        return precisao;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    private int getRand(){
        Random r = new Random();
        return r.nextInt(1,99);
    }
}

