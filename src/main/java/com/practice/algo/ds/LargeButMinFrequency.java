package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given an array A of size N. The elements of the array consists of positive integers.
 * You have to find the largest element with minimum frequency.
 *
 * e.g
 * Input:
 * 2 2 5 50 1
 *
 * Output:
 * 50
 */
public class LargeButMinFrequency {

    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0 && testCount % 2 == 0) {
                System.out.println(largeButMinFreq(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray(),
                        6));
            }
            testCount++;
        }
    }

    private static int largeButMinFreq(int[] arr, int n) {
        Map<Integer, Integer> elementFrequencyMap = new HashMap<>();
        SortedMap<Integer, SortedSet<Integer>> frequencyElementListMap = new TreeMap<>();
        for (int element : arr) {
            if (elementFrequencyMap.get(element) != null &&
                    frequencyElementListMap.get(elementFrequencyMap.get(element)) != null) {
                frequencyElementListMap.get(elementFrequencyMap.get(element))
                        .remove(element);
                if (frequencyElementListMap.get(elementFrequencyMap.get(element)).isEmpty()) {
                    frequencyElementListMap.remove(elementFrequencyMap.get(element));
                }
            }
            elementFrequencyMap.put(element,
                    elementFrequencyMap.getOrDefault(element, 0) + 1);
            frequencyElementListMap.computeIfAbsent(elementFrequencyMap.get(element),
                    z -> new TreeSet<>()).add(element);
        }
        return frequencyElementListMap.get(frequencyElementListMap.firstKey()).last();
    }
}
