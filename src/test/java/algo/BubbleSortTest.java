package test.java.algo;

import main.java.algo.BubbleSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BubbleSortTest {
    SortTest sortTest = new SortTest(new BubbleSort<>());
    @Before
    public void prepareTestAndSortedArrays() {
        sortTest.prepareTestAndSortedArrays();
    }
    @Test
    public void testSort() {
        sortTest.testSort();
    }
    @Test
    public void testSortWithComparator() {
        sortTest.testSortWithComparator();
    }
}
