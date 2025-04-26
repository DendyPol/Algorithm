package ru.polovinko;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcatInteger {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1, 2));
        lists.add(List.of(3, 4));
        lists.add(List.of(5, 6));

        System.out.println("Using loop: ");
        List<Integer> testLoop = concatUsingLoop(lists);
        System.out.println(testLoop);

        System.out.println("Using stream: ");
        List<Integer> testStream = concatUsingStream(lists);
        System.out.println(testStream);
    }

    public static List<Integer> concatUsingLoop(List<List<Integer>> lists) {
        List<Integer> concat = new ArrayList<>();

        for (int i = 0; i < lists.size() - 1; i++) {
            List<Integer> current = lists.get(i);
            List<Integer> next = lists.get(i + 1);
            for (Integer a : current) {
                for (Integer b : next) {
                    concat.add(Integer.parseInt(a.toString() + b.toString()));
                }
            }
        }
        return concat;
    }

    public static List<Integer> concatUsingStream(List<List<Integer>> lists) {
        return IntStream.range(0, lists.size() - 1)
                .boxed()
                .flatMap(i -> lists.get(i).stream()
                        .flatMap(a -> lists.get(i + 1).stream()
                                .map(b -> Integer.parseInt(a.toString() + b.toString()))
                        )
                )
                .collect(Collectors.toList());
    }
}
