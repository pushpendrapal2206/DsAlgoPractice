package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MoveOneLeft {
    private static Map<String, Integer> storage = new HashMap<>();
    private static int counter;

    public static void main(String[] s) {
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        array.add(list);
        List<Integer> list2 = new ArrayList<>(list);
        List<Integer> list3 = new ArrayList<>(list);
        List<Integer> list4 = new ArrayList<>(list);
        array.add(list2);
        array.add(list3);
        array.add(list4);
//        list.add(2);
//        list.add(7);
//        list.add(8);
//        list.add(9);
//        list.add(10);
//        list.add(11);
//        list.add(11);
//        list.add(1);
//        list.add(0);
//        list.add(1);
//        int removal = Math.min(removeFromLeft(list), removeFromRight(list));
//        System.out.println(numberOfPaths(array));
    }

    public static int removeFromLeft(List<Integer> input) {
        if (input.indexOf(0) == -1 || input.lastIndexOf(1) == -1
                || input.indexOf(0) > input.lastIndexOf(1)) {
            return 0;
        }
        List<Integer> tempList = new ArrayList<>(input);
        tempList.remove(input.indexOf(0));
        return 1 + Math.min(removeFromLeft(new ArrayList<>(tempList)),
                removeFromRight(new ArrayList<>(tempList)));
    }

    public static int removeFromRight(List<Integer> input) {
        if (input.indexOf(0) == -1 || input.lastIndexOf(1) == -1
                || input.indexOf(0) > input.lastIndexOf(1)) {
            return 0;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.remove(1);
        List<Integer> tempList = new ArrayList<>(input);
        tempList.remove(input.lastIndexOf(1));
        return 1 + Math.min(removeFromRight(new ArrayList<>(tempList)),
                removeFromLeft(new ArrayList<>(tempList)));
    }

    public static String plusMult(List<Integer> A) {
        int i = 0;
        int j = 1;
        int operationCount = 0;
        double rEven = 1;
        double rOdd = 1;
        while (i < A.size()) {
            if (i % 2 == 0 || i == 0) {
                rEven = rEven * A.get(i);
            } else {
                rOdd = rOdd * A.get(j);
            }
            if (operationCount % 2 != 0 || i == 0 || j == 1) {
                rEven = rEven * A.get(i);
                if (j < A.size())
                    rOdd = rOdd * A.get(j);
            } else {
                rEven = rEven + A.get(i);
                if (j < A.size())
                    rOdd = rOdd + A.get(j);
            }
            i += 2;
            j += 2;
            operationCount++;
        }
        return rEven % 2 > rOdd % 2 ? "EVEN" : rEven % 2 == rOdd % 2 ? "NEUTRAL" : "ODD";
    }

    public static void finalPrice(List<Integer> prices) {
        int totalPrice = 0;
        int j = 0;
        List<Integer> fullPriceArray = new ArrayList<>();
        while (j < prices.size()) {
            int i = j + 1;
            boolean found = false;
            while (i < prices.size()) {
                if (prices.get(j) >= prices.get(i)) {
                    found = true;
                    totalPrice = totalPrice + (prices.get(j) - prices.get(i));
                    break;
                }
                i++;
            }
            if (!found) {
                totalPrice = totalPrice + prices.get(j);
                fullPriceArray.add(j);
            }
            j++;
        }

        System.out.println(totalPrice);
        fullPriceArray.forEach(element -> System.out.print(element + " "));

    }
}
