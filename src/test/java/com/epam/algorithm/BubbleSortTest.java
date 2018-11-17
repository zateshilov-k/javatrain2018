package com.epam.algorithm;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
    SortTest sortTest = new SortTest(new BubbleSort<>());

    @Before
    public void prepareTestAndSortedArrays() {
        sortTest.prepareTestAndSortedArrays(false);
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
