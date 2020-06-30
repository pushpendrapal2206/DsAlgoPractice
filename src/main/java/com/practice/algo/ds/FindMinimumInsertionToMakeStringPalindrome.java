package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class FindMinimumInsertionToMakeStringPalindrome {
    private Map<String, Integer> map = new HashMap<>();

    public int findMinimumInsertion(String s) {
        int start = 0;
        int end = s.length() - 1;
        if ("".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 0;
        }
        if (s.length() == 2 && s.charAt(start) != s.charAt(end)) {
            return 1;
        }

        if (s.charAt(start) == s.charAt(end)) {
            if (map.containsKey(s)) {
                return map.get(s);
            }
            map.put(s, findMinimumInsertion(s.substring(start + 1, end)));
            return map.get(s);
        } else {
            if (map.containsKey(s)) {
                return map.get(s);
            }
            map.put(s, 1 + Math.min(findMinimumInsertion(s.substring(start, end)), findMinimumInsertion(s.substring(start + 1, end + 1))));
            return map.get(s);
        }

    }

    public static void main(String[] s) {
        System.out.println(new FindMinimumInsertionToMakeStringPalindrome().findMinimumInsertion("abcd"));
        System.out.println(new FindMinimumInsertionToMakeStringPalindrome().findMinimumInsertion("abcde"));
        System.out.println(new FindMinimumInsertionToMakeStringPalindrome().findMinimumInsertion("abcda"));
        System.out.println(new FindMinimumInsertionToMakeStringPalindrome().findMinimumInsertion("aa"));
        System.out.println(new FindMinimumInsertionToMakeStringPalindrome().findMinimumInsertion("ab"));
        System.out.println(new FindMinimumInsertionToMakeStringPalindrome().findMinimumInsertion("a"));
    }
}
