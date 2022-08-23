package aula20;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {
    private String cnpj;
    private String razaoSocial;

    private List<Funcionario> funcionarioList = new ArrayList<>();
    public Empresa(String cnpj, String razaoSocial, List<Funcionario> funcionarioList) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.funcionarioList = funcionarioList;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }
}
