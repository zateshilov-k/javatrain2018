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
