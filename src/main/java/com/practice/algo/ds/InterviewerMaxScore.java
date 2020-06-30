package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array find maximum sum such that no 2 adjacent elements are considered.
 * e.g Given a = {1,2,10,11}
 * Max Sum = 13.
 */
public class InterviewerMaxScore {

    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0 && testCount % 2 == 0) {
                System.out.println(getMaxScore(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray()));
            }
            testCount++;
        }
    }

    private static int getMaxScore(int[] scores) {
        int sumOdd = 0;
        int sumEven = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i % 2 == 0) {
                sumEven += scores[i];
            } else {
                sumOdd += scores[i];
            }
        }
        return Math.max(sumEven, sumOdd);
    }

    private static int getDynamicMaxScore(int[] scores) {
        int[] sum = new int[scores.length];
        int maxSumIndex = 0;
        for (int i = 0; i < scores.length; i++) {
            if (i - maxSumIndex > 1) {
                sum[i] = sum[maxSumIndex] + scores[i];
            } else {
                sum[i] = scores[i];
            }
            if (sum[i] > sum[maxSumIndex]) {
                maxSumIndex = i;
            }
        }
        return sum[maxSumIndex];
    }
}
