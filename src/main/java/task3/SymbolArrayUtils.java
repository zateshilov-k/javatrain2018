package main.java.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 12.270 Напечатать строку, образованую символами, расположенными в четырёх углах массива (в любом порядке)
 * 12.271 Составить программу, которая печатает слово, образованное несколькими идущими подряд символами
 *        с заданными номерами, расположенными в некоторой строке массива
 * 12.272 Дан двумерный массив размером 5х5, заполненный буквами. Напечатать
 *        слово,  образованное  элементами  массива,  отмеченными  звездочкой:, при прочтении их:
 *        а)слева направо в каждой строке, начиная с первой;
 *        б)сверху вниз в каждом столбце, начиная с первого.
 *        |*| |*| |*|
 *        | |*| |*| |
 *        |*| |*| |*|
 *        | |*| |*| |
 *        |*| |*| |*|
 */
public class SymbolArrayUtils {
    public static String getCornerSymbols(char[][] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Must be more than 2 rows");
        }
        if (array[array.length - 1].length < 2) {
            throw new IllegalArgumentException("Must be more than 2 columns");
        }

        return "" + array[0][0] + array[0][array[0].length - 1]
                + array[array.length - 1][0]
                + array[array.length - 1][array[array.length - 1].length - 1];
    }

    public static String getWordFromArray(char[][] array, int rowIdx, int startColumnIdx, int endColumnIdx) {
        if ((rowIdx < 0) || (startColumnIdx < 0) || (endColumnIdx < 0)) {
            throw new IllegalArgumentException("Indexes must be more than 0.");
        }
        if (rowIdx >= array.length) {
            throw new ArrayIndexOutOfBoundsException("rowIdx must be less than array.length.");
        }
        if (endColumnIdx >= array[rowIdx].length) {
            throw new ArrayIndexOutOfBoundsException("endColumnIdx must be less than array[rowIdx].length.");
        }
        return new String(Arrays.copyOfRange(array[rowIdx], startColumnIdx, endColumnIdx + 1));
    }

    public static String getWordFromChessArray(char[][] array, Direction direction) {
        for (char[] outArr : array) {
            if (outArr.length != array.length) {
                throw new IllegalArgumentException("Array must be square!");
            }
        }
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = (i % 2 == 0) ? 0 : 1; j < array[i].length; j += 2) {
                switch (direction) {
                    case LEFT_TO_RIGHT: {
                        result += array[i][j];
                        break;
                    }
                    case TOP_TO_BOTTOM: {
                        result += array[j][i];
                        break;
                    }
                    default: {
                        System.err.println("Unknown direction.");
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getEvenSymbolsFromArrayRows(char[][] array) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        for (char[] currArr : array) {
            for (int columnIdx = 0; columnIdx < currArr.length; columnIdx += 2) {
                currentString.append(currArr[columnIdx]);
            }
            result.add(currentString.toString());
            currentString.setLength(0);
        }
        return result;
    }

    public static ArrayList<String> getOddSymbolsFromArrayColumns(char[][] array) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        for (int rowIdx = 1; rowIdx < array.length; rowIdx += 2) {
            for (int columnIdx = 0; columnIdx < array[rowIdx].length; columnIdx++) {

            }
        }
        return result;
    }

    public enum Direction {
        LEFT_TO_RIGHT,
        TOP_TO_BOTTOM
    }

    public static void main(String[] args) {
        char[][] matrix = {"ab".toCharArray(), "cd".toCharArray()};
        int column = 10;

        Object[] col = IntStream.range(0, matrix.length).mapToObj(i ->(char)i).toArray();
        Character[] arr = Arrays.copyOf(col,col.length,Character[].class);
    }
}

