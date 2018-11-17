package com.epam.chararray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharArrayUtils {
    /**
     * Return string of 4 corner elements of array.
     *
     * @param array input array
     * @return resulting string with size = 4
     */
    public static String getCornerChars(char[][] array) {
        if (array.length < 2 || array[array.length - 1].length < 2) {
            throw new IllegalArgumentException("Illegal array size.");
        }
        return "" + array[0][0] + array[0][array[0].length - 1]
                + array[array.length - 1][0]
                + array[array.length - 1][array[array.length - 1].length - 1];
    }

    /**
     * Return word from chosen row of array between chosen start index and end index.
     *
     * @param array          input two-dimensional array
     * @param rowIdx         index of chosen row
     * @param startColumnIdx first index of word
     * @param endColumnIdx   last index of word
     * @return resulting string
     */
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

    /**
     * Return elements of "chess board" array, example:
     * |*| |*| |*|
     * | |*| |*| |
     * |*| |*| |*|   - 5*5 "chess board" array
     * | |*| |*| |
     * |*| |*| |*|
     *
     * @param array     input two-dimensional array
     * @param direction define direction of array traversal LEFT_TO_RIGHT, TOP_TO_BOTTOM
     * @return resulting string
     */
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

    /**
     * Return array of words, formed by even elements of every row of input array.
     *
     * @param array input two-dimensional array
     * @return resulting array of words
     */
    public static ArrayList<String> getEvenElementsFromArrayRows(char[][] array) {
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

    /**
     * Return array of words, formed by odd elements of every column of input array.
     *
     * @param array input two-dimensional array
     * @return resulting array of words
     */
    public static ArrayList<String> getOddElementsFromArrayColumns(char[][] array) {
        int rowLength = array[0].length;
        for (char[] currentArray : array) {
            if (currentArray.length != rowLength) {
                throw new IllegalArgumentException("Array must be rectangular");
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for (int columnIdx = 0; columnIdx < array[0].length; ++columnIdx) {
            final int currCol = columnIdx;
            Character[] col = IntStream
                    .range(0, array.length)
                    .filter(i -> i % 2 != 0)
                    .map(i -> i = array[i][currCol])
                    .mapToObj(i -> (char) i)
                    .toArray(Character[]::new);
            // Cast Character[] to String
            List<Character> list = Arrays.asList(col);
            String stringFromCharacterArray = list
                    .stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining());
            result.add(stringFromCharacterArray);
        }
        return result;
    }

    public enum Direction {
        LEFT_TO_RIGHT,
        TOP_TO_BOTTOM
    }
}

