// src/main/java/lab14/sict/must/edu/mn/Division.java
package lab14.sict.must.edu.mn;

/**
 * Division calculator.
 */
public class Division {
    /**
     * Divides two numbers.
     * @param a numerator
     * @param b denominator
     * @return quotient of a and b
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}