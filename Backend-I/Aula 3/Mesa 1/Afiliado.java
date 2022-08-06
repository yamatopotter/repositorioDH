package aula3;

public class Afiliado extends Vendedor{

    public Afiliado(String nome) {
        super(nome);
    }

    @Override
    public void vender() {
        this.setVendas(this.getVendas()+1);
    }

    @Override
    public int calcularPontos() {
        int pontos = (this.getVendas()*15);
        return pontos;
    }
}
