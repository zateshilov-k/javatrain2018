package main.java.algo;

import java.util.Comparator;

public interface SortingAlgorithm<T extends Comparable<T>> {
    default void swap(T[] array, int firstIdx, int secondIdx) {
        T temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }
    default void sort(T[] inputArray) {
        Comparator<T> comparator = Comparable::compareTo;
        sort(inputArray,comparator);
    }
    void sort(T[] inputArray, Comparator<? super T> comparator);
}
