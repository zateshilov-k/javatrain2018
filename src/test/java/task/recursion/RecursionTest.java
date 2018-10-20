package test.java.task.recursion;

import main.java.task.recursion.Recursion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionTest {
    Recursion recursion = new Recursion();

    @Test
    public void testFactorial() {
        assertEquals(1, recursion.factorial(0));
        assertEquals(24, recursion.factorial(4));
        assertEquals(3_628_800, recursion.factorial(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_throws() {
        recursion.factorial(-1);
    }

    @Test
    public void testPow() {
        assertEquals(27, recursion.pow(3, 3), 10E-10);
        assertEquals(1.44, recursion.pow(1.2, 2), 10E-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPow_throws() {
        recursion.pow(3, -1);
    }

    @Test
    public void testSumDigits() {
        assertEquals(3, recursion.sumDigits(101010));
        assertEquals(15, recursion.sumDigits(12345));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumDigits_throws() {
        recursion.sumDigits(-1);
    }

    @Test
    public void testCountDigits() {
        assertEquals(6, recursion.countDigits(101010));
        assertEquals(5, recursion.countDigits(12345));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountDigits_throws() {
        recursion.countDigits(-2);
    }
}
