package aula1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {
    Figura c1, c2, c3;

    @BeforeEach
    void doBefore(){
        c1 = new Circulo(3.25);
        c2 = new Circulo(1.0);
        c3 = new Circulo(2.0);
    }

    @Test
    void calcularPerimetro() {
        System.out.println(c1.calcularPerimetro());

        double resultC2 = c2.calcularPerimetro();
        assertEquals(6.283185307179586, c2.calcularPerimetro());
        System.out.println(c3.calcularPerimetro());
    }
}