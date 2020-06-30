package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestWordInDictionary {
    // O(n + (m * (k+k))) = O(n+(m*k)) = O(mk)
    public static List<String> largestWordInDict(List<String> dict, String input) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        Map<Integer, List<String>> outputMap = new HashMap<>();
        int maxLength = 0;
        for (char c : input.toCharArray()) { // O(n) n is the size of input string
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0) + 1);
        }

        for (String word : dict) { // O(m) m is the number of words in dict
            Map<Character, Integer> characterInWordFreqMap = new HashMap<>();
            for (char c : word.toCharArray()) { // O(k) k is the length of largest word in dict
                characterInWordFreqMap.put(c, characterInWordFreqMap.getOrDefault(c, 0) + 1); //
            }
            boolean eachKeyPresent = characterInWordFreqMap.entrySet().stream()
                    .noneMatch(entry -> characterFrequencyMap.getOrDefault(entry.getKey(), 0) < entry.getValue());

            if (eachKeyPresent) {
                outputMap.computeIfAbsent(word.length(), z -> new ArrayList<>()).add(word);
                if (maxLength < word.length()) {
                    maxLength = word.length();
                }
            }
        }
        return outputMap.get(maxLength);
    }

    public static void main(String[] s) {
        System.out.println(largestWordInDict(Arrays.asList("ale", "apple", "monkey", "plea"), "abpcplea"));
        System.out.println(largestWordInDict(Arrays.asList("pintu", "geeksfor", "geeksgeeks", " forgeek"), "geeksforgeeks"));
    }
}
