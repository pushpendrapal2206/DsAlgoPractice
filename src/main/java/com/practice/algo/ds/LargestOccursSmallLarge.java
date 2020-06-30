package com.practice.algo.ds;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class LargestOccursSmallLarge {

    public static String solution(String s) {
        Map<Character, Boolean> map = new TreeMap<>(Comparator.reverseOrder());
        for (char c : s.toCharArray()) {
            if (map.containsKey(c) && !map.get(c)) {
                if (c >= 'a') {
                    map.remove(c);
                    map.put((char) (c - 32), true);
                } else {
                    map.put(c, true);
                }
            } else {
                if (c < 'a') {
                    map.put((char) (c + 32), false);
                } else {
                    map.put((char) (c - 32), false);
                }
            }
        }

        Optional<Map.Entry<Character, Boolean>> character = map.entrySet().stream().filter(Map.Entry::getValue).findFirst();

        if (character.isPresent()) {
            return character.get().getKey().toString();
        }
        return "NO";
    }

    public static void main(String[] s) {
        System.out.println(LargestOccursSmallLarge.solution("Codility"));
        System.out.println(LargestOccursSmallLarge.solution("WeTestCoDErs"));
        System.out.println(LargestOccursSmallLarge.solution("aaBabcDaAd"));
    }
}
