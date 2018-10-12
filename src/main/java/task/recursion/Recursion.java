package main.java.task.recursion;

public class Recursion {
    public static long factorial(int n) {
        if (n < 0 ) {
            throw new IllegalArgumentException("n should be natural");
        }
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
    public static double pow(double num, int pow) {
        if (pow < 0 ) {
            throw new IllegalArgumentException("pow should be natural");
        }
        if (pow == 0) {
            return 1;
        } else {
            return num*pow(num,pow-1);
        }
    }
    public static int sumDigits(int num) {
        if (num < 0 ) {
            throw new IllegalArgumentException("n should be natural");
        }
        if (num / 10 == 0) {
            return 1;
        } else {
            return (num % 10 + sumDigits(num / 10));
        }

    }
    public static int countDigits(int num) {
        if (num < 0 ) {
            throw new IllegalArgumentException("n should be natural");
        }
        if (num / 10 == 0) {
            return 1;
        } else {
            return (1 + countDigits(num/10));
        }
    }
}
