package test.java.task2;

import main.java.task2.StringsUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringsUtilTest {
    final String testStringLetters = "abcdefgh";

    @Test
    public void testGetStringSymbol() {
        assertEquals('c', StringsUtil.getStringSymbol(testStringLetters, 2));
        assertEquals('h', StringsUtil.getStringSymbol(testStringLetters, testStringLetters.length() - 1));
        int k = 4;
        assertEquals('e', StringsUtil.getStringSymbol(testStringLetters, k));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testWrongLetterPosition() {
        StringsUtil.getStringSymbol(testStringLetters, testStringLetters.length());
    }

    @Test
    public void testCountEqualNeighbouringLetters() {
        assertEquals(0, StringsUtil.countEqualNeighbouringLetters(""));
        assertEquals(0, StringsUtil.countEqualNeighbouringLetters("   "));
        assertEquals(0, StringsUtil.countEqualNeighbouringLetters("77"));
        assertEquals(2, StringsUtil.countEqualNeighbouringLetters("aa"));
        assertEquals(3, StringsUtil.countEqualNeighbouringLetters("aaa"));
        assertEquals(7, StringsUtil.countEqualNeighbouringLetters("aaa  bb cc"));
    }

    @Test
    public void testSwapLetters() {
        assertEquals("bacdefgh", StringsUtil.swapLetters(testStringLetters, 0, 1));
        assertEquals("Snritg", StringsUtil.swapLetters("String", 1, 4));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    void testSwapLettersThrowsException() {
        StringsUtil.swapLetters("abc", 1, 3);
    }
}
