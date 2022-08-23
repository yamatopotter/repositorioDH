package aula19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {

    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();

        Contato contato1 = new Contato("Matheus",  "matheuspbarreto@hotmail.com.br", "21-999999999");
        Contato contato2 = new Contato("Angélica",  "angelica_1992@hotmail.com.br", "21-999999999");
        Contato contato3 = new Contato("Debora",  "deborass@hotmail.com.br", "21-999999999");

        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);

        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("contatos.bin");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contatos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
