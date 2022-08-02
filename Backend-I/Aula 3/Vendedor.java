package aula3;

public abstract class Vendedor {
    private int vendas = 0;
    private String nome;

    public Vendedor(String nome){
        this.nome = nome;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public void mostrarCategoria(){
        int pontos = this.calcularPontos();

        System.out.println(this.nome);
        System.out.println("Pontos: "+pontos);

        if(pontos>40){
            System.out.println("Categoria: Mestre");
        } else if (pontos >= 31) {
            System.out.println("Categoria: Bom");
        } else if (pontos >= 20){
            System.out.println("Categoria: Aprendiz");
        } else{
            System.out.println("Categoria: Novato");
        }
    }

    public abstract void vender();
    public abstract int calcularPontos();
}
