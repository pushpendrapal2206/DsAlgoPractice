package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Given a stream of characters, find the first non-repeating character from stream. in O(1) time.
 */
public class FirstUniqueElementInStream {
    static Map<Character, Integer> frequencyMap;
    static Map<Integer, Queue<Character>> frequencyCharQueueMap;

    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0 && testCount % 2 == 0) {
                frequencyMap = new HashMap<>();
                frequencyCharQueueMap = new HashMap<>();
                System.out.println(insertIntoStream(line.replaceAll(" ", "")));
            }
            testCount++;
        }
    }

    static String insertIntoStream(String input) {
        String output = "";
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            frequencyCharQueueMap.computeIfAbsent(frequencyMap.get(c), z -> new ArrayDeque<>()).add(c);
        }
        return output + frequencyCharQueueMap.get(1).peek();
    }
}
