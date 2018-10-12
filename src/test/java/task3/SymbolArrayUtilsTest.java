package test.java.task3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static main.java.task3.SymbolArrayUtils.*;
import static org.junit.Assert.assertEquals;

public class SymbolArrayUtilsTest {
    @Test
    public void testGetCornerElements() {
        char[][] testArray = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        assertEquals("acgi", getCornerSymbols(testArray));

        testArray = new char[][]{
                "ab".toCharArray(),
                "cd".toCharArray()
        };
        assertEquals("abcd", getCornerSymbols(testArray));

        testArray = new char[][]{
                "abc".toCharArray(),
                "d".toCharArray(),
                "efg".toCharArray()
        };
        assertEquals("aceg", getCornerSymbols(testArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCornerElements_oneDimArray() {
        getCornerSymbols(new char[][]{"abc".toCharArray()});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCornerElements_triangleArray() {
        getCornerSymbols(new char[][]{
                "abc".toCharArray(),
                "c".toCharArray()
        });
    }

    @Test
    public void testGetWordFromArray() {
        char[][] testArray = {"dog".toCharArray(), "cat".toCharArray(), "wolf".toCharArray()};
        assertEquals("cat", getWordFromArray(testArray, 1, 0, 2));
        assertEquals("wo", getWordFromArray(testArray, 2, 0, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromArray_negativeIdx() {
        char[][] testArray = {"ab".toCharArray(), "cd".toCharArray()};
        getWordFromArray(testArray, -1, 0, 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetWordFromArray_outOfBound() {
        char[][] testArray = {"ab".toCharArray(), "cd".toCharArray()};
        getWordFromArray(testArray, 2, 0, 1);
    }

    @Test
    public void testGetWordFromChessBoardArray() {
        char[][] array = {
                "a b c".toCharArray(),
                " d e ".toCharArray(),
                "f g h".toCharArray(),
                " i j ".toCharArray(),
                "k l m".toCharArray()
        };
        assertEquals("abcdefghijklm", getWordFromChessArray(array, Direction.LEFT_TO_RIGHT));
        assertEquals("afkdibglejchm", getWordFromChessArray(array, Direction.TOP_TO_BOTTOM));
        /*assertThrows(IllegalArgumentException.class,
                () -> {
                    SymbolArrayUtils.getWordFromChessArray(new char[][]{
                            "abc".toCharArray(),
                            "c".toCharArray()
                    }, true);
                });
         */
    }

    @Test
    public void testGetEvenSymbolsFromArrayRows() {
        char[][] testArray = {"ABCD".toCharArray(), "EFGH".toCharArray()};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("AC","EG"));
        assertEquals(expected,getEvenSymbolsFromArrayRows(testArray));
    }

}