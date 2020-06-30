package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Build a stack which returns element with maximum frequency in O(1) time.
 * It should provide the function implementation push and pop both in O(1) time.
 */
public class MaxFrequencyStack {
    private int maxFreq = 0;
    private Map<Integer, Stack<Integer>> group = new HashMap<>();
    private Map<Integer, Integer> freq = new HashMap<>();


    public void push(int i) {
        freq.put(i, freq.getOrDefault(i, 0) + 1);
        if (freq.get(i) >= maxFreq) {
            maxFreq = freq.get(i);
        }
        group.computeIfAbsent(freq.get(i), z -> new Stack<>()).push(i);
    }

    public int pop() {
        int output = group.get(maxFreq).pop();
        freq.put(output, freq.get(output) - 1);
        if (group.get(maxFreq).size() == 0)
            maxFreq = maxFreq - 1;
        return output;
    }

    public static void main(String[] s) {
        MaxFrequencyStack stack = new MaxFrequencyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        boolean result = stack.pop() == 1 && stack.pop() == 3 && stack.pop() == 2;
        stack.push(3);
        result = result && stack.pop() == 3 && stack.pop() == 1 && stack.pop() == 4 &&
                stack.pop() == 3 && stack.pop() == 2 && stack.pop() == 1;
        if (result) {
            System.out.println("All test passed!");
        } else {
            System.out.println("There are test failures!");
        }
    }
}
