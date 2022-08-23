package aula19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("contatos.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            contatos = (ArrayList) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for(Contato contato:contatos){
            System.out.println("Nome: "+ contato.getNome()+" | "+contato.getEmail()+" | "+contato.getTelefone());
        }
    }
}
