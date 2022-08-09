package aula7;

public class Arvore {
    private String cor, tipoArvore;
    private int altura, largura;

    public Arvore(String cor, String tipoArvore, int altura, int largura) {
        this.cor = cor;
        this.tipoArvore = tipoArvore;
        this.altura = altura;
        this.largura = largura;
    }

    public String getCor() {
        return cor;
    }

    public String getTipoArvore() {
        return tipoArvore;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }
}
