package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUniqueCharacters {

    private static int matchingCharacters(String str) {
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maximumLength = 0;
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                int count = (int) str.substring(map.get(c) + 1, i).chars().distinct().count();
                if (count > maximumLength) {
                    maximumLength = count;
                }
            } else {
                map.put(c, i);
            }
            i++;
        }
        return maximumLength;
    }

    public static void main(String[] s) {
        System.out.println(NumberOfUniqueCharacters.matchingCharacters("ahyjakh"));
        System.out.println(NumberOfUniqueCharacters.matchingCharacters("abccdafghi"));
        System.out.println(NumberOfUniqueCharacters.matchingCharacters("mmmerme"));
    }

}
