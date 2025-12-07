// src/main/java/labxx/sict/must/edu/mn/Division.java
package lab14.sict.must.edu;

/**
 * Division calculator with enhanced error handling.
 */
public class Division {
    /**
     * Divides two numbers with validation.
     * @param a numerator
     * @param b denominator
     * @return quotient of a and b
     * @throws IllegalArgumentException if b is zero or NaN
     */
    public double divide(double a, double b) {
        if (Double.isNaN(b) || Double.isInfinite(b)) {
            throw new IllegalArgumentException("Invalid denominator");
        }
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}