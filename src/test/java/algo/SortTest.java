package test.java.algo;

import main.java.algo.SortingAlgorithm;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortTest {
    final int ARRAY_SIZE = 10_000;
    SortingAlgorithm<Integer> sortingAlgorithm;
    Integer[] testArray;
    Integer[] sortedArray;
    Integer[] reverseSortedArray;

    public SortTest(SortingAlgorithm<Integer> sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void prepareTestAndSortedArrays() {
        Random random = new Random();
        testArray = new Integer[ARRAY_SIZE];
        for (int i = 0; i < testArray.length; ++i) {
            testArray[i] = random.nextInt();
        }
        sortedArray = testArray.clone();
        reverseSortedArray = testArray.clone();
        Arrays.parallelSort(sortedArray);
        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        Arrays.parallelSort(reverseSortedArray, comparator.reversed());
    }

    public void testSort() {
        Integer[] ourSortedArray = testArray.clone();
        sortingAlgorithm.sort(ourSortedArray);
        Assert.assertArrayEquals(sortedArray, ourSortedArray);
    }

    public void testSortWithComparator() {
        Integer[] ourSortedArray = testArray.clone();
        Comparator<Integer> comparator = Comparator.comparingInt(i -> i);
        sortingAlgorithm.sort(ourSortedArray, comparator.reversed());
        Assert.assertArrayEquals(reverseSortedArray, ourSortedArray);
    }
}
