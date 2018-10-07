package test.java.task3;

import main.java.task3.SymbolArrayUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SymbolArrayUtilsTest {
    @Test
    public void getCornerElementsWorksProperly() {
        char[][] testArray = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        assertEquals("acgi", SymbolArrayUtils.getCornerSymbols(testArray));

        testArray = new char[][]{
                "ab".toCharArray(),
                "cd".toCharArray()
        };
        assertEquals("abcd", SymbolArrayUtils.getCornerSymbols(testArray));

        testArray = new char[][]{
                "abc".toCharArray(),
                "d".toCharArray(),
                "efg".toCharArray()
        };
        assertEquals("aceg", SymbolArrayUtils.getCornerSymbols(testArray));
    }

    @Test
    public void wrongArraySizeWorksProperly() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    SymbolArrayUtils.getCornerSymbols(new char[][] {"abc".toCharArray()});
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    SymbolArrayUtils.getCornerSymbols(new char[][] {
                            "abc".toCharArray(),
                            "c".toCharArray()
                    });
                });
    }
}
