// src/test/java/lab14/sict/must/edu/mn/MultiplicationTest.java
package lab14.sict.must.edu.mn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Multiplication class.
 */
public class MultiplicationTest {
    @Test
    void testMultiplyPositive() {
        Multiplication calc = new Multiplication();
        assertEquals(6.0, calc.multiply(2.0, 3.0),
                "2 * 3 should equal 6");
    }

    @Test
    void testMultiplyNegative() {
        Multiplication calc = new Multiplication();
        assertEquals(-6.0, calc.multiply(-2.0, 3.0),
                "-2 * 3 should equal -6");
    }

    @Test
    void testMultiplyZero() {
        Multiplication calc = new Multiplication();
        assertEquals(0.0, calc.multiply(0.0, 5.0),
                "0 * 5 should equal 0");
    }
}