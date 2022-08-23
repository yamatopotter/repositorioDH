package aula20;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CreateFileEmpresa {
    public static void main(String[] args) {
        List<Funcionario> funcionario1 = new ArrayList<>();
        List<Funcionario> funcionario2 = new ArrayList<>();

        Funcionario f1 = new Funcionario("Matheus", "Barreto", "255148524", 2500.00);
        Funcionario f2 = new Funcionario("Juliane", "Alves", "36544125", 2500.00);
        funcionario1.add(f1);
        funcionario1.add(f2);

        Funcionario f3 = new Funcionario("Thiago", "Silva", "96203296", 2500.00);
        Funcionario f4 = new Funcionario("Luiz", "Espicalsky", "74856749", 2500.00);
        funcionario2.add(f3);
        funcionario2.add(f4);

        Empresa empresa1 = new Empresa("23651661000185", "Apollo TI", funcionario1);
        Empresa empresa2 = new Empresa("23651661000185", "MB Info", funcionario2);

        FileOutputStream fos = null;

        try{
//            Criação da empresa 1
            fos = new FileOutputStream("./src/main/java/aula20/"+empresa1.getRazaoSocial().replaceAll("\s+", "")+".bin");

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empresa1);

//            Criação da empresa 2
            fos = new FileOutputStream("./src/main/java/aula20/"+empresa2.getRazaoSocial().replaceAll("\s+", "")+".bin");

            oos = new ObjectOutputStream(fos);
            oos.writeObject(empresa2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
