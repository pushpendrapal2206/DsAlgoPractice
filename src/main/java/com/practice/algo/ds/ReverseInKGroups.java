package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * Company Tags: Amazon, Microsoft, Bloomberg, Airbnb, Adobe
 * Tags: Linked List, Math
 * Similar Problems: (M) Multiply Strings, (E) Add Binary, (E) Sum of Two Integers, (E) Add Strings, (M) Add Two Numbers
 * II
 */

public class ReverseInKGroups {
    
    
    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }
        if(n==1) {
            return "1";
        }
        return say(countAndSay(n-1));
    }
    
    private String say(String input) {
        String output = "";
        Map<String, Integer> map = new HashMap<>();
        char previous = '\n';
        for(char c : input.toCharArray()) {
            String key = String.valueOf(c);
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (previous != c && previous != '\n') {
                String previousKey = String.valueOf(previous);
                output = output + map.get(previousKey) + previousKey;
                map.remove(previousKey);
            }
            previous = c;
        }
        String previousKey = String.valueOf(previous);
        output = output + map.get(previousKey) + previousKey;
        return output;
    }
    
    
    
    
    public static void main(String[] s) {
        ReverseInKGroups solution = new ReverseInKGroups();
        for (int i = -2; i<=5; i++) {
            System.out.println("countAndSay(" + i + "): " + solution.countAndSay(i));
        }
    }
}
