package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Routers {
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  ArrayList<ArrayList<Integer>> links) {
        Map<Integer, List<Integer>> map = new HashMap<>();


        for (List<Integer> list : links) {
            map.computeIfAbsent(list.get(0), z -> new ArrayList<>()).add(list.get(1));
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int i : map.get(entry.getKey())) {
                for (int input : map.get(i)) {

                }
            }
        }

        return null;
    }

    private void DFS(int v, boolean[] visited, Map<Integer, List<Integer>> map) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer n : map.get(v)) {

            if (n != null && !visited[n])
                DFS(n, visited, map);
        }
    }

    public static void main(String[] s) {
        ArrayList<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(2);
        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(2);
        input2.add(3);
        ArrayList<Integer> input3 = new ArrayList<>();
        input3.add(3);
        input3.add(4);
        ArrayList<Integer> input4 = new ArrayList<>();
        input4.add(4);
        input4.add(5);
        ArrayList<Integer> input5 = new ArrayList<>();
        input5.add(6);
        input5.add(3);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(input1);
        input.add(input2);
        input.add(input3);
        input.add(input4);
        input.add(input5);

        new Routers().criticalRouters(6, 5, input);
    }
}
