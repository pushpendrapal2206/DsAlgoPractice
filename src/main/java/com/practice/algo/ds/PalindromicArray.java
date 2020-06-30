package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PalindromicArray {
    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0 && testCount % 2 == 0) {
                System.out.println(numberOfOpToMakePalindrome(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray()));
            }
            testCount++;
        }
    }

    private static int numberOfOpToMakePalindrome(int[] input) {
        int operation = 0;
        int i = 0;
        int j = input.length - 1;
        while (i <= j) {
            if (input[i] < input[j]) {
                i++;
                input[i] = input[i] + input[i - 1];
                operation++;
            } else if (input[i] > input[j]) {
                j--;
                input[j] = input[j] + input[j + 1];
                operation++;
            } else {
                i++;
                j--;
            }
        }
        return operation;
    }
}
