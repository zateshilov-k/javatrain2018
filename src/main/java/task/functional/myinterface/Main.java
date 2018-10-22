package main.java.task.functional.myinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TriConsumer<Integer[], Integer, Integer> consumer = Arrays::sort;
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1,2,3,12,3,1,2});
        list.add(new Integer[]{-2,0,2,3,2,1,2});

        List<Integer[]> result = new ArrayList<>();
        for (Integer[] integers : list) {
            consumer.accept(integers,0, integers.length);
        }
        list.stream().map(Arrays::toString).forEach(System.out::println);

    }
}
