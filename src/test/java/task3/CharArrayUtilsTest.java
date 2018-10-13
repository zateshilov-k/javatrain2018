package test.java.task3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static main.java.task3.CharArrayUtils.*;
import static org.junit.Assert.assertEquals;

public class CharArrayUtilsTest {
    @Test
    public void testGetCornerElements() {
        char[][] testArray = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        assertEquals("acgi", getCornerChars(testArray));

        testArray = new char[][]{
                "ab".toCharArray(),
                "cd".toCharArray()
        };
        assertEquals("abcd", getCornerChars(testArray));

        testArray = new char[][]{
                "abc".toCharArray(),
                "d".toCharArray(),
                "efg".toCharArray()
        };
        assertEquals("aceg", getCornerChars(testArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCornerElementsOneDimArray() {
        getCornerChars(new char[][]{"abc".toCharArray()});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCornerElementsTriangleArray() {
        getCornerChars(new char[][]{
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
    public void testGetWordFromArrayNegativeIdx() {
        char[][] testArray = {"ab".toCharArray(), "cd".toCharArray()};
        getWordFromArray(testArray, -1, 0, 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetWordFromArrayOutOfBound() {
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

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordFromChessBoardArrayWrongArraySize() {
        getWordFromChessArray(new char[][]{"abc".toCharArray(), "c".toCharArray()}, Direction.LEFT_TO_RIGHT);
    }

    @Test
    public void testGetEvenElementsFromArrayRows() {
        char[][] testArray = {"ABCD".toCharArray(), "EFGH".toCharArray()};
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("AC", "EG"));
        assertEquals(expected, getEvenElementsFromArrayRows(testArray));

        testArray = new char[][]{"0123456789".toCharArray()};
        expected = new ArrayList<>(Arrays.asList("02468"));
        assertEquals(expected, getEvenElementsFromArrayRows(testArray));
    }

    @Test
    public void testGetOddElementsFromArrayColumns() {
        char[][] testArray = {
                "abc".toCharArray(),
                "def".toCharArray(),
                "ghi".toCharArray(),
                "jkl".toCharArray()
        };
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("dj", "ek", "fl"));
        assertEquals(expected, getOddElementsFromArrayColumns(testArray));

        testArray = new char[][]{
                "*****".toCharArray(),
                "01234".toCharArray(),
                "*****".toCharArray(),
                "56789".toCharArray(),
                "*****".toCharArray(),
        };
        expected = new ArrayList<>(Arrays.asList("05", "16", "27", "38", "49"));
        assertEquals(expected, getOddElementsFromArrayColumns(testArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOddElementsFromArrayColumnsWrongArraySize() {
        char[][] testArray = {"ABC".toCharArray(), "A".toCharArray()};
        getOddElementsFromArrayColumns(testArray);
    }


}