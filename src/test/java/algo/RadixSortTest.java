package test.java.algo;

import main.java.algo.QuickSort;
import main.java.algo.RadixSort;
import org.junit.Before;
import org.junit.Test;

public class RadixSortTest {
    SortTest sortTest = new SortTest(new RadixSort());

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
