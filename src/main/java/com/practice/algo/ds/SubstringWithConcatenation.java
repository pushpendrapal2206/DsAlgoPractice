package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {

        if (words.length == 0) {
            return Collections.EMPTY_LIST;
        }
        if (words[0].length() == 0) {
            return Collections.EMPTY_LIST;
        }

        Map<String, Integer> map = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        int start = 0;
        int wordStart = 0;
        int wordLength = words[0].length();
        int end = wordLength;
        int lengthOfSubstring = wordLength * words.length;

        populateMap(map, words);

        while (end <= s.length()) {
            String input = s.substring(wordStart, end);
            if (map.getOrDefault(input, 0) > 0) {
                map.put(input, map.get(input) - 1);
                if (end - start < lengthOfSubstring) {
                    wordStart = end;
                    end = end + wordLength;
                }
                else if (map.values().stream().allMatch(element -> element == 0)) {
                    output.add(start);
                    start++;
                    wordStart = start;
                    end = wordStart + wordLength;
                    populateMap(map, words);
                }
            }
            else {
                start++;
                wordStart = start;
                end = wordStart + wordLength;
                populateMap(map, words);
            }
        }
        return output;
    }

    private void populateMap(Map<String, Integer> map, String[] words) {
        map.clear();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public static void main(String[] s) {
        System.out.println(new SubstringWithConcatenation().findSubstring("aaaaaaaa",
                new String[]{"aa","aa","aa"}));
    }
}
