package aula7;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String, Arvore> arvoreFlyweight = new HashMap<>();

    public Arvore getArvore(String cor, String tipo, int altura, int largura){
        String id = "arvore:c-"+cor+"t-"+tipo+"a-"+altura+"i-"+largura;
//        System.out.println(id);

        if(!arvoreFlyweight.containsKey(id))
        {
            arvoreFlyweight.put(id,new Arvore(cor, tipo, altura, largura));
//            System.out.println("\nÁrvore criada com sucesso");
            return arvoreFlyweight.get(id);
        }

//        System.out.println("\nÁrvore obtida");
        return arvoreFlyweight.get(id);
    }
}
