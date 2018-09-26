package test.java.task2;

import main.java.task2.StringsUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringsUtilTest {
    final String testStringLetters = "abcdefgh";

    @Test
    public void getStringSymbolWorks() {
        assertEquals('c', StringsUtil.getStringSymbol(testStringLetters, 2));
        assertEquals('h', StringsUtil.getStringSymbol(testStringLetters, testStringLetters.length() - 1));
        int k = 4;
        assertEquals('e', StringsUtil.getStringSymbol(testStringLetters, k));
    }

    @Test
    public void wrongLetterPositionWorksProperly() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            StringsUtil.getStringSymbol(testStringLetters, testStringLetters.length());
        });
    }

    @Test
    public void countEqualNeighbouringLettersWorksProperly() {
        assertEquals(0, StringsUtil.countEqualNeighbouringLetters(""));
        assertEquals(0, StringsUtil.countEqualNeighbouringLetters("   "));
        assertEquals(0, StringsUtil.countEqualNeighbouringLetters("77"));
        assertEquals(2, StringsUtil.countEqualNeighbouringLetters("aa"));
        assertEquals(3, StringsUtil.countEqualNeighbouringLetters("aaa"));
        assertEquals(7, StringsUtil.countEqualNeighbouringLetters("aaa  bb cc"));
    }

    @Test
    public void swapLettersWorksProperly() {
        assertEquals("bacdefgh", StringsUtil.swapLetters(testStringLetters, 0, 1));
        assertEquals("Snritg", StringsUtil.swapLetters("String", 1, 4));
    }

    @Test
    void swapLettersWrongPositionWorksProperly() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            StringsUtil.swapLetters("abc", 1, 3);
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            StringsUtil.swapLetters("abc", 3, 1);
        });
    }
}
