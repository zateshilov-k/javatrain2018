package test.java.algo;

import main.java.algo.BubbleSort;
import main.java.algo.MergeSort;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    SortTest sortTest = new SortTest(new MergeSort<>());
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
