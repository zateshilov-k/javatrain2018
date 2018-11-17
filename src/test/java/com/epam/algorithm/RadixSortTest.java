package com.epam.algorithm;

import org.junit.Before;
import org.junit.Test;

public class RadixSortTest {
    SortTest sortTest = new SortTest(new RadixSort());

    @Before
    public void prepareTestAndSortedArrays() {
        sortTest.prepareTestAndSortedArrays(true);
    }

    @Test
    public void testSort() {
        sortTest.testSort();
    }

    @Test
    public void testSortWithComparator() {
    }
}
