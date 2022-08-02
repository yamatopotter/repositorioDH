package aula1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTest {
    Figura q1, q2, q3;

    @BeforeEach
    void doBefore(){
        q1 = new Quadrado(2);
        q2 = new Quadrado(4);
        q3 = new Quadrado(8);
    }

    @Test
    void calcularPerimetro() {
        System.out.println(q1.calcularPerimetro());

        double resultC2 = q2.calcularPerimetro();
        assertEquals(16.0, q2.calcularPerimetro());
        System.out.println(q3.calcularPerimetro());
    }
}