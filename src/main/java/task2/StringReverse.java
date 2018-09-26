package main.java.task2;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        String input;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Enter string to reverse or 'exit' to quit.");
            input = keyboard.nextLine();
            System.out.println(new StringBuffer(input).reverse());
        } while (!input.equals("exit"));
    }
}
