package aula10;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Random;
public class Media {
    private static final Logger logger = Logger.getLogger(Media.class);
    private ArrayList<Integer> listaInteiros = new ArrayList<>();

    public void addNumeroLista(int numero){
        if(listaInteiros.size()<1){
            logger.error("A lista está vazia");
        }
        else if(listaInteiros.size()>5){
            logger.info("A lista possui mais de 5 itens");
        }
        else if(listaInteiros.size()>10){
            logger.info("A lista possui mais de 10 itens");
        }

        listaInteiros.add(numero);
    }

    public void mediaListaInteiro(){
        int soma=0;
        Double media=0.0;
        for (Integer numero: listaInteiros){
            soma += numero;
        }

        media = Double.valueOf(soma/listaInteiros.size());
        logger.info("A média é: "+media);
    }

}
