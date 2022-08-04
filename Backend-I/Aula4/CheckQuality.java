package aula4;

public class CheckQuality {

    public static void main(String[] args) {
        Gerenciador gerenciador = new GerenciadorLote().setGerenciadorSeguinte(new GerenciadorPeso().setGerenciadorSeguinte(new GerenciadorEmbalagem()));

        TestaProduto(gerenciador);
    }

    public static void TestaProduto(Gerenciador gerenciador){
        Produto p1 = new Produto("Produto 1", 1200, 1250, "Saudável");
        Produto p2 = new Produto("Produto 2", 250, 1250, "Saudável");
        Produto p3 = new Produto("Produto 3", 1200, 1400, "Saudável");
        Produto p4 = new Produto("Produto 4", 1200, 1250, "Ruim");

        gerenciador.verificar(p1);
        gerenciador.verificar(p2);
        gerenciador.verificar(p3);
        gerenciador.verificar(p4);
    }
}
