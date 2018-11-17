package com.epam.algorithm;

import java.util.Comparator;

public class RadixSort implements SortingAlgorithm<Integer> {
    static int getMax(Integer[] inputArray) {
        int max = inputArray[0];
        for (Integer integer : inputArray) {
            if (integer > max) {
                max = integer;
            }
        }
        return max;
    }

    @Override
    public void sort(Integer[] inputArray, Comparator<? super Integer> comparator) {
        int max = getMax(inputArray);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(inputArray, exp);
        }
    }

    private void countSort(Integer[] inputArray, int exp) {
        Integer outputArray[] = new Integer[inputArray.length]; // output array
        int i;
        int count[] = new int[10];

        for (i = 0; i < inputArray.length; i++) {
            count[(inputArray[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = inputArray.length - 1; i >= 0; i--) {
            outputArray[count[(inputArray[i] / exp) % 10] - 1] = inputArray[i];
            count[(inputArray[i] / exp) % 10]--;
        }

        for (i = 0; i < inputArray.length; i++)
            inputArray[i] = outputArray[i];
    }
}
