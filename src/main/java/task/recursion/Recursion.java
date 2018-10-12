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
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(pow(3,3));

        System.out.println(sumDigits(12345));
        System.out.println(sumDigits(10100));

        System.out.println(countDigits(2));
        System.out.println(countDigits(12345));
        System.out.println(countDigits(101010));
    }
}
