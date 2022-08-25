package com.odonto.consultorio.model;

public class Usuario {
    private int id;
    private String nome, email, senha, nivelAcesso;

    public Usuario(String nome, String email, String senha, String nivelAcesso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public Usuario(int id,String nome, String email, String senha, String nivelAcesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setId(int id) {
        this.id = id;
    }
}
