package aula7;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int aux;

        ArvoreFactory gerenciadorDeArvores = new ArvoreFactory();
        ArrayList<Arvore> floresta = new ArrayList<>();

        for(aux=0; aux<500000; aux++){
            floresta.add(gerenciadorDeArvores.getArvore("verde", "Ornamentais", 200, 400));
        }

        for(aux=0; aux<500000; aux++){
            floresta.add(gerenciadorDeArvores.getArvore("vermelha", "Frutíferas", 500, 300));
        }

        for(aux=0; aux<500000; aux++) {
            floresta.add(gerenciadorDeArvores.getArvore("azul", "Florífera", 100, 200));
        }

//        for(aux=0; aux<2000000; aux++){
//            floresta.add(new Arvore("verde", "Ornamentais", 200, 400));
//        }
//        570MB

        System.out.println(floresta.toString());
        System.out.println("Quantidade de árvores: "+floresta.size());

        Runtime runtime = Runtime.getRuntime();

        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)+"MB");
    }
}
