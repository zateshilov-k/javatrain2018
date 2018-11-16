package main.java.algo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort implements SortingAlgorithm<Integer> {
    @Override
    public void sort(Integer[] inputArray, Comparator<? super Integer> comparator) {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++)
            buckets[i] = new LinkedList<Integer>();

        boolean sorted = false;
        int expo = 1;

        while ( ! sorted) {
            sorted = true;

            for (int item : inputArray) {
                int bucket = (item / expo) % 10;
                if (bucket > 0) sorted = false;
                buckets[bucket].add(item);
            }

            expo *= 10;
            int index = 0;

            for (Queue<Integer> bucket : buckets)
                while ( ! bucket.isEmpty())
                    inputArray[index++] = bucket.remove();
        }
    }
}
