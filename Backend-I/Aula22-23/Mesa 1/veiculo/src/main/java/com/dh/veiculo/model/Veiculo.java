package com.dh.veiculo.model;

public class Veiculo {
    private String marca, cor, logo;

    public Veiculo(String marca, String cor, String logo) {
        this.marca = marca;
        this.cor = cor;
        this.logo = logo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public String getLogo() {
        return logo;
    }
}
