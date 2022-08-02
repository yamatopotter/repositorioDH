package aula3;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Vanessa", LocalDate.of(2018,07,01));
        Funcionario f2 = new Funcionario("Fernando", LocalDate.of(2020,07,01));
        Afiliado a1 = new Afiliado("Regina");
        Afiliado a2 = new Afiliado("Taynan");

        a1.vender();
        a1.vender();
        a1.vender();
        a2.vender();
        f1.vender();
        f1.afiliar();
        f1.vender();
        f2.afiliar();
        f2.afiliar();
        f2.afiliar();
        f2.vender();

        f1.mostrarCategoria();
        f2.mostrarCategoria();
        a1.mostrarCategoria();
        a2.mostrarCategoria();
    }
}
