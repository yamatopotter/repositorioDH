package aula3;

import java.time.LocalDate;
import java.util.Date;

public class Funcionario extends Vendedor{
    private int afiliados;
    private LocalDate dataContratacao;

    public Funcionario(String nome, LocalDate dataContratacao) {
        super(nome);
        this.dataContratacao = dataContratacao;
    }

    @Override
    public void vender() {
        this.setVendas(this.getVendas()+1);
    }

    public void setAfiliados(int afiliados) {
        this.afiliados = afiliados;
    }

    public int getAfiliados(){
        return this.afiliados;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void afiliar(){
        this.setAfiliados(this.getAfiliados()+1);
    }

    @Override
    public int calcularPontos(){
        int pontos = (this.afiliados * 10) + (this.getVendas()*5);
        pontos += (LocalDate.now().getYear()-this.getDataContratacao().getYear())*5;
        return pontos;
    }
}
