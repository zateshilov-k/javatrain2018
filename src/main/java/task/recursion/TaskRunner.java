package main.java.task.recursion;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TaskRunner {
    Recursion r = new Recursion();
    int power;

    public TaskRunner(int power) {
        this.power = power;
    }

    /**
     * Print table for all methods in Recursion class.
     *
     * @param startRange start of range methods arguments
     * @param endRange   end of range methods arguments
     */
    public void printTableForMethods(int startRange, int endRange) {
        Map<String, Function<Integer, Long>> unaryMethods = r.getUnaryMethods();
        for (String name : unaryMethods.keySet()) {
            System.out.println(name);
            for (int i = startRange; i < endRange; i++) {
                System.out.print("Input: " + i + " ");
                System.out.print("Output: " + unaryMethods.get(name).apply(i) + " ");
                System.out.println();
            }
            System.out.println();
        }
        Map<String, BiFunction<Double, Integer, Double>> biFunctions = r.getBiMethods();
        for (String name : biFunctions.keySet()) {
            System.out.println(name);
            System.out.println("Power = " + power);
            for (int i = startRange; i < endRange; i++) {
                System.out.print("Input: " + i + " ");
                System.out.print("Output: " + biFunctions.get(name).apply((double) i, power) + " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
