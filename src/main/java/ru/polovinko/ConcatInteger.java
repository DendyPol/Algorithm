package ru.polovinko;

import java.util.ArrayList;
import java.util.List;

public class ConcatInteger {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1, 2));
        lists.add(List.of(3, 4));
        lists.add(List.of(5, 6));

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
        System.out.println(concat);
    }
}
