package com.epam.algorithm;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
    SortTest sortTest = new SortTest(new QuickSort<>());

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
