package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

public class UniquePathInMaze {
    public static void main(String[] s) {
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        array.add(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>(list);
        array.add(list2);
        array.add(list3);
        System.out.println(numberOfPaths(array));
    }

    public static int numberOfPaths(List<List<Integer>> b) {
        List<List<Integer>> a = new ArrayList<>(b);
        int totalRow = a.size();
        int totalColumn = a.get(0).size();
        if (a.get(0).get(0) == 0) {
            return 0;
        }
        for (int i = 1; i < totalRow; i++) {
            for (int j = 1; j < totalColumn; j++) {
                if (a.get(i).get(j) == 0)
                    continue;
                if (a.get(i).get(j) > 0) {
                    b.get(i).set(j, b.get(i - 1).get(j) + b.get(i).get(j - 1));
                }
            }
        }

        if (b.get(totalRow - 1).get(totalColumn - 1) > 0) {
            return b.get(totalRow - 1).get(totalColumn - 1);
        }
        return 0;
    }
}
