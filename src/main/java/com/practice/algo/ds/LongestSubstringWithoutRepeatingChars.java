package com.practice.algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        return (int) s.chars().mapToLong(c -> {
            int startOfWindow = 0;
            int endOfWindow = -1;
            int maxLength = -1;
            int j = 0;
            if (!map.containsKey((char) c)) {
                endOfWindow = j;
                map.put((char) c, j);
            } else {
                maxLength = Math.max(maxLength, endOfWindow - startOfWindow + 1);
                if (startOfWindow <= map.get((char) c)) {
                    startOfWindow = map.get((char) c) + 1;
                } else {
                    endOfWindow = j;
                }
                map.put((char) c, j);
            }
            return Math.max(maxLength, endOfWindow - startOfWindow + 1);
        }).max().getAsLong();
    }

    public static void main(String s[]) {
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("tmmzuxt"));
    }
}
