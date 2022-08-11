package aula10;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Media listaNumero = new Media();
        Random gerador = new Random();

        for(int i=0; i<15; i++){
            listaNumero.addNumeroLista(gerador.nextInt());
        }

        listaNumero.mediaListaInteiro();
    }


}
