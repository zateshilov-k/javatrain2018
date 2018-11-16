package main.java.algo;

import java.util.Comparator;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    Random random = new Random();

    @Override
    public void sort(T[] inputArray, Comparator<? super T> comparator) {
        quicksort(inputArray, 0, inputArray.length - 1, comparator);
    }

    private void quicksort(T[] array, int low, int high, Comparator<? super T> comparator) {
        if (low < high) {
            int pivotIdx = partition(array, low, high, comparator);
            quicksort(array, low, pivotIdx - 1, comparator);
            quicksort(array, pivotIdx + 1, high, comparator);
        }
    }

    private int partition(T[] array, int low, int high, Comparator<? super T> comparator) {
        int index = low + random.nextInt(high - low + 1);
        T pivot = array[index];
        swap(array, index, high);
        for (int i = index = low; i < high; ++i) {
            if (comparator.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, high);
        return index;
    }
}