package test.java.task.recursion;

import org.junit.Test;

import static main.java.task.recursion.Recursion.*;
import static org.junit.Assert.assertEquals;

public class RecursionTest {
    @Test
    public void testFactorial() {
        assertEquals(1, factorial(0));
        assertEquals(24, factorial(4));
        assertEquals(3_628_800, factorial(10));
        assertEquals(62_270_208_00l, factorial(13));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_throws() {
        factorial(-1);
    }

    @Test
    public void testPow() {
        assertEquals(27, pow(3, 3), 10E-10);
        assertEquals(1.44, pow(1.2, 2), 10E-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPow_throws() {
        pow(3, -1);
    }

    @Test
    public void testSumDigits() {
        assertEquals(3, sumDigits(101010));
        assertEquals(15, sumDigits(12345));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSumDigits_throws() {
        sumDigits(-1);
    }

    @Test
    public void testCountDigits() {
        assertEquals(6, countDigits(101010));
        assertEquals(5, countDigits(12345));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCountDigits_throws() {
        countDigits(-2);
    }
}
