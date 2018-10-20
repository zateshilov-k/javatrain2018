package main.java.task.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Recursion {
    private final Map<String, Function<Integer, Long>> unaryMethods = new HashMap<>();
    private final Map<String, BiFunction<Double, Integer, Double>> biMethods = new HashMap<>();

    public Recursion() {
        unaryMethods.put("Factorial", this::factorial);
        unaryMethods.put("Sum all digits of number", this::sumDigits);
        unaryMethods.put("Count all digits of number", this::countDigits);
        biMethods.put("Power of double", this::pow);
    }

    public Map<String, BiFunction<Double, Integer, Double>> getBiMethods() {
        return new HashMap<>(biMethods);
    }

    public Map<String, Function<Integer, Long>> getUnaryMethods() {
        return new HashMap<>(unaryMethods);
    }

    /**
     * Calculate factorial with recursion.
     *
     * @param n natural number
     * @return factorial of n
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be natural");
        }
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Calculate power of double with recursion.
     *
     * @param num number for which the power is calculated
     * @param pow power
     * @return result
     */
    public double pow(double num, int pow) {
        if (pow < 0) {
            throw new IllegalArgumentException("pow should be natural");
        }
        if (pow == 0) {
            return 1;
        } else {
            return num * pow(num, pow - 1);
        }
    }

    /**
     * Calculate sum of all digits.
     *
     * @param num number for which sum of all digits is calculated
     * @return sum of all digits
     */
    public long sumDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("n should be natural");
        }
        if (num / 10 == 0) {
            return 1;
        } else {
            return (num % 10 + sumDigits(num / 10));
        }

    }

    /**
     * Count number of digits of number.
     *
     * @param num number for which we are couniting digits
     * @return result
     */
    public long countDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("n should be natural");
        }
        if (num / 10 == 0) {
            return 1;
        } else {
            return (1 + countDigits(num / 10));
        }
    }
}
