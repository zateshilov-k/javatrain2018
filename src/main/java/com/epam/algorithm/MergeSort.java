package com.epam.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] inputArray, Comparator<? super T> comparator) {
        mergeSort(inputArray, inputArray.length, comparator);
    }

    private void mergeSort(T[] inputArray, int length, Comparator<? super T> comparator) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        T[] l = Arrays.copyOfRange(inputArray,0,mid);
        T[] r = Arrays.copyOfRange(inputArray,0,length-mid);
        for (int i = 0; i < mid; i++) {
            l[i] = inputArray[i];
        }
        for (int i = mid; i < length; i++) {
            r[i - mid] = inputArray[i];
        }
        mergeSort(l, mid, comparator);
        mergeSort(r, length - mid, comparator);
        merge(inputArray, l, r, mid, length - mid, comparator);
    }

    private void merge(T[] inputArray, T[] l, T[] r, int left, int right, Comparator<? super T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l[i], r[j]) < 0) {
                inputArray[k++] = l[i++];
            } else {
                inputArray[k++] = r[j++];
            }
        }
        while (i < left) {
            inputArray[k++] = l[i++];
        }
        while (j < right) {
            inputArray[k++] = r[j++];
        }
    }
}
