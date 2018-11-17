package com.epam.algorithm;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
    SortTest sortTest = new SortTest(new MergeSort<>());
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
