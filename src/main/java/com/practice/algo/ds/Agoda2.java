package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * <p>
 * Input: s = "dvdf"
 * Output: 3
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * Input: s = " "
 * Output: 1
 * <p>
 * <p>
 * length = 4
 * 'a', true
 * 'b', true
 * 'c', true
 * 'd', true
 * <p>
 * abcabccdbb
 * <p>
 * <p>
 * s = 9
 * e = 9
 * 3
 * <p>
 * a, 3
 * b, 8
 * c, 6
 * d, 7
 */
public class Agoda2 {
    
    public static void main(String[] args) {
//        System.out.println(findSumOfDuplicates(new int[] {-7,-7,1,5,5}));
        System.out.print(findLengthofNonDuplicateSubstring("pwwkew"));
    }
    
    public static int findSumOfDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        boolean isDuplicate = false;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) == 2) {
                sum = sum + key;
                isDuplicate = true;
            }
        }
        
        if (!isDuplicate) {
            return -1;
        }
        return sum;
    }
    
    //pwwkew
    public static int findLengthofNonDuplicateSubstring(String input) {
        if (input.length() == 0) {
            return 0;
        }
        if (input.length() == 1) {
            return 1;
        }
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int s = 0;
        int e = 0;
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                int previousIndex = map.get(c) + 1;
                if (s < previousIndex) {
                    s = previousIndex;
                }
            }
            if (maxLength < e - s + 1) {
                maxLength = e - s + 1;
            }
            map.put(c, i); // p, 0 |  w, 1                                  i = 2, e =2, s=0, ml = 2
            i++;
            e++;
        }
        return maxLength;
    }
}
