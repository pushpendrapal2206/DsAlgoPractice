package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings string1 and string2,
 * the task is to find the smallest substring in string1 containing all characters of string2 efficiently.
 * <p>
 * e.g Input: string = “this is a test string”, pattern = “tist”
 * Output: Minimum window is “t stri”
 */
public class FindSmallestWindowStringContainsAllChar {

    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        String input = "";
        String pattern;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount % 2 != 0) {
                input = line;
            }
            if (testCount != 0 && testCount % 2 == 0) {
                pattern = line;
                System.out.println(findSmallest(input, pattern));
            }
            testCount++;
        }
//        System.out.println(findSmallest("this is a test string", "tist"));
    }

    public static String findSmallest(String s, String p) {
        int patternLength = p.length();
        int stringLength = s.length();
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < patternLength; i++) {
            patternMap.put(p.charAt(i), patternMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int count = 0;
        int start = 0;
        int end = stringLength - 1;
        int minimumLength = 10000000;
        int start_index = -1;

        for (int j = 0; j < stringLength; j++) {
            stringMap.put(s.charAt(j), stringMap.getOrDefault(s.charAt(j), 0) + 1);
            if (patternMap.containsKey(s.charAt(j))
                    && stringMap.get(s.charAt(j)) <= patternMap.get(s.charAt(j))) {
                count++;
            }

            if (count == patternLength) {
                while (stringMap.getOrDefault(s.charAt(start), 0) > patternMap.getOrDefault(s.charAt(start), 0)) {
                    stringMap.put(s.charAt(start), stringMap.get(s.charAt(start)) - 1);
                    start++;
                }
                int minLength = j - start + 1;
                if (minLength < minimumLength) {
                    minimumLength = minLength;
                    start_index = start;
                }
            }

        }
        if (start_index == -1) {
            return "-1";
        }
        return s.substring(start_index, start_index + minimumLength);
    }
}
