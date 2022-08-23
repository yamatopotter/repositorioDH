package aula20;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String nome;
    private String sobrenome;
    private String documento;
    private Double salario;

    public Funcionario(String nome, String sobrenome, String documento, Double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public Double getSalario() {
        return salario;
    }
}
