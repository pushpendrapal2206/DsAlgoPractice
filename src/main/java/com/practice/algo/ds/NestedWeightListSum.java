package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Problem Description:
 * Given a nested list of integers, the objective is to return the sum of all integers in the list,
 * where each integer's contribution is its value multiplied by its depth.
 * An element's depth refers to the number of nested lists it resides within.
 * For example, an integer directly in the main list has a depth of 1,
 * an integer within a list at depth 1 has a depth of 2, and so on.
 * <p>
 * Example:
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: The four '1's are at depth 2 (1 * 4 * 2 = 8), and the '2' is at depth 1 (2 * 1 = 2).
 * Total sum = 8 + 2 = 10.
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: The '1' is at depth 1 (1 * 1 = 1), the '4' is at depth 2 (4 * 2 = 8),
 * and the '6' is at depth 3 (6 * 3 = 18). Total sum = 1 + 8 + 18 = 27.
 */
public class NestedWeightListSum {
    public static class NestedInteger {
        int value;
        boolean isInteger;
        List<NestedInteger> list;

        public NestedInteger(int value, boolean isInteger, List<NestedInteger> list) {
            this.value = value;
            this.isInteger = isInteger;
            this.list = list;
        }
    }

    public static class Pair {
        int depth;
        NestedInteger ni;

        public Pair(int depth, NestedInteger ni) {
            this.depth = depth;
            this.ni = ni;
        }
    }


    public int sumNestedList(List<NestedInteger> input) {
        int sum = 0;
        Queue<List<Pair>> queue = new ArrayDeque<>();
        List<Pair> pairs = input.stream()
                .map(ni -> new Pair(1, ni))
                .collect(Collectors.toList());
        queue.offer(pairs); // [{1, [1,1]}, {1, 2}, {1, [1,1]}]
        while (!queue.isEmpty()) {
            List<Pair> list = queue.poll(); // [{2, 1} {2, 1}]
            for (Pair p : list) { // [{2, 1} {2, 1}]
                if (p.ni.isInteger) {
                    sum = sum + (p.ni.value * p.depth); // 10
                } else {
                    List<Pair> cp = p.ni.list.stream()
                            .map(ni -> new Pair(p.depth + 1, ni))
                            .collect(Collectors.toList());
                    queue.offer(cp); // [{2, 1} {2, 1}], [{2, 1} {2, 1}]
                }
            }
        }
        return sum;
    }

    public static void main(String[] s) {
        NestedWeightListSum ns = new NestedWeightListSum();
        List<NestedInteger> nestedIntegers = new ArrayList<>();
        NestedInteger cni1 = new NestedInteger(1, true, null);
        NestedInteger cni2 = new NestedInteger(1, true, null);
        nestedIntegers.add(cni1);
        nestedIntegers.add(cni2);
        List<NestedInteger> nestedIntegers2 = new ArrayList<>();
        NestedInteger cni21 = new NestedInteger(1, true, null);
        NestedInteger cni22 = new NestedInteger(1, true, null);
        nestedIntegers.add(cni21);
        nestedIntegers.add(cni22);
        NestedInteger ni1 = new NestedInteger(2, true, null);
        NestedInteger ni2 = new NestedInteger(0, false,nestedIntegers );
        NestedInteger ni3 = new NestedInteger(0, false, nestedIntegers2);

        List<NestedInteger> input = new ArrayList<>();
        input.add(ni2);
        input.add(ni1);
        input.add(ni3);
        System.out.println(ns.sumNestedList(input));
    }

}
