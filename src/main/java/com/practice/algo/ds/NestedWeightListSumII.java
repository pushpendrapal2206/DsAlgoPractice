package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Different from the previous question where weight is increasing from root to leaf,
 * now the weight is defined from bottom up. i.e., the leaf level integers have weight 1,
 * and the root level integers have the largest weight.
 * Example1:
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 8
 * Explanation:
 * four 1's at depth 1, one 2 at depth 2
 * <p>
 * Example2:
 * Input: nestedList = [1,[4,[6]]]
 * Output: 17
 * Explanation:
 * one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1
 * 1*3 + 4*2 + 6*1 = 17
 */
public class NestedWeightListSumII {
    int maxheight = 1;

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


    public int sumNestedList(List<NestedInteger> input) { // [[1,1],2,[1,1]]
        calculateHeight(input); // 2
        int sum = 0;
        List<Pair> pairs = input.stream()
                .map(pair -> new Pair(0, pair))
                .collect(Collectors.toList()); // [{0, [1,1]}, {0, 2}, {0,[1,1]}]
        Queue<List<Pair>> queue = new ArrayDeque<>();
        queue.offer(pairs);

        while (!queue.isEmpty()) {
            List<Pair> p = queue.poll(); //[{1, 1}, {1,1}]
            for (Pair pair : p) {
                if (pair.ni.isInteger) { //{1, 1}
                    sum = sum + (pair.ni.value * (maxheight - pair.depth)); // 5
                } else {
                    List<Pair> cpairs = pair.ni.list.stream()
                            .map(cp -> new Pair(pair.depth + 1, cp))
                            .collect(Collectors.toList()); //, [{1,1} {1,1}]
                    queue.offer(cpairs);
                }
            }
        }
        return sum;
    }

    private int calculateHeight(List<NestedInteger> input) { // [[1,1],2,[1,1]]
        if (input == null) {
            return 0;
        }
        int height = 1;
        for (NestedInteger ni : input) {
            if (ni.isInteger) {
                return 1;
            }
            height = height + calculateHeight(ni.list); // 2
            maxheight = Math.max(maxheight, height);

        }
        return maxheight;
    }

    public static void main(String[] s) {
        NestedWeightListSumII ns = new NestedWeightListSumII();
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
        NestedInteger ni2 = new NestedInteger(0, false, nestedIntegers);
        NestedInteger ni3 = new NestedInteger(0, false, nestedIntegers2);

        List<NestedInteger> input = new ArrayList<>();
        input.add(ni2);
        input.add(ni1);
        input.add(ni3);
        System.out.println(ns.sumNestedList(input));
    }

}
