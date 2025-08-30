package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of strings, for each string determine number of replacements required to make the adjacent characters of string different.
 * Eg: add - 1, boook - 1, abc - 0 (Hint: Count consecutive characters)
 */
public class MinReplacements {

    public int minReplacement(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int totalReplacements = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 1) + 1);
            } else {
                if (map.containsKey(input.charAt(i))) {
                    totalReplacements = totalReplacements + map.get(input.charAt(i)) / 2;
                    map.remove(input.charAt(i));
                }
            }
        }
        return totalReplacements;
    }

    public static void main(String[] args) {
        System.out.println(new MinReplacements().minReplacement("addboookabc"));
    }


}
