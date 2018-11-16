package main.java.algo;

import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] inputArray, Comparator<? super T> comparator) {
        for (int i = 0; i < inputArray.length; ++i) {
            boolean isSwapped = false;
            for (int j = 0; j < inputArray.length - i - 1; ++j) {
                if (comparator.compare(inputArray[j], inputArray[j + 1]) > 0) {
                    swap(inputArray, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) return;
        }
    }
}
