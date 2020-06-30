package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given a pattern containing only I's and D's. I for increasing and D for decreasing.
 * Devise an algorithm to print the minimum number following that pattern.
 * Digits from 1-9 and digits can't repeat.
 * <p>
 * <p>
 * Example:
 * Input
 * 5
 * D
 * I
 * DD
 * IIDDD
 * DDIDDIID
 * <p>
 * Output
 * 21
 * 12
 * 321
 * 126543
 * 321654798
 */
public class NumberFollowingPattern {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0) {
                System.out.println(pattern(line));
            }
            testCount++;
        }
    }

    private static String pattern(String s) {
        String output = "1";
        int max = 1;
        int i = 0;
        for (char c : s.toCharArray()) {
            max = max + 1;
            if (c == 'D') {
                output = output.substring(0, i) + max + output.substring(i, output.length());
            } else if (c == 'I') {
                output = output + max;
                i = output.length() - 1;
            }
        }
        return output;
    }


}
