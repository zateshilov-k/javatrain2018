package main.java.task3;

/* 12.270 Напечатать строку, образованую символами, расположенными в четырёх углах массива (в любом порядке)
 * 12.271 Составить программу, которая печатает слово, образованное несколькими идущими подряд символами
 *        с заданными номерами, расположенными в некоторой строке массива
 *
 */
public class SymbolArrayUtils {
    public static String getCornerSymbols(char[][] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Must be more than 2 rows");
        }
        if (array[array.length-1].length < 2) {
            throw new IllegalArgumentException("Must be more than 2 rows");
        }

        return "" + array[0][0] + array[0][array[0].length-1]
                + array[array.length-1][0]
                + array[array.length-1][array[array.length-1].length-1];
    }
}
