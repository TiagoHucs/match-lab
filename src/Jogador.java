public class Jogador {
    private String nome;
    private int forca;
    private int precisao;
    private String posicao;

    public Jogador(String nome, int forca, int precisao, String posicao) {
        this.nome = nome;
        this.forca = forca;
        this.precisao = precisao;
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
}

