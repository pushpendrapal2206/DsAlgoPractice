package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

public class TravelerFund {
    public static void main(String[] s) {
        List<Integer> input = new ArrayList<>();
        input.add(-3);
        input.add(2);
        input.add(4);
        input.add(-7);
        System.out.println(requiredAmountAtStart(input));
    }

    public static int requiredAmountAtStart(List<Integer> netSaving) {
        int initialAmount = 1;
        int windowSum = 0;
        for (int input : netSaving) {
            windowSum = windowSum + input;
            if (windowSum < 0) {
                initialAmount = initialAmount + Math.abs(windowSum);
                windowSum = 0;
            }
        }
        return initialAmount > 1 ? initialAmount : 0;
    }
}
