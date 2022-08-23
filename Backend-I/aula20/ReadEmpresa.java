package aula20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadEmpresa {
    public static void main(String[] args) {
        Empresa empresa1, empresa2;

        FileInputStream fis = null;

        try{
            fis = new FileInputStream("./src/main/java/aula20/ApolloTI.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            empresa1 = (Empresa) ois.readObject();

            fis = new FileInputStream("./src/main/java/aula20/MBInfo.bin");
            ois = new ObjectInputStream(fis);

            empresa2 = (Empresa) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Empresa: "+empresa1.getRazaoSocial());
        System.out.println("CNPJ: "+empresa1.getCnpj());
        for(Funcionario f: empresa1.getFuncionarioList()){
            System.out.println("Nome: "+f.getNome()+" "+f.getSobrenome());
            System.out.println("Documento: "+f.getDocumento());
            System.out.println("Salario: "+f.getSalario());
        }

        System.out.println("-------------------------------");

        System.out.println("Empresa: "+empresa2.getRazaoSocial());
        System.out.println("CNPJ: "+empresa2.getCnpj());
        for(Funcionario f: empresa2.getFuncionarioList()){
            System.out.println("Nome: "+f.getNome()+" "+f.getSobrenome());
            System.out.println("Documento: "+f.getDocumento());
            System.out.println("Salario: "+f.getSalario());
        }
    }
}
