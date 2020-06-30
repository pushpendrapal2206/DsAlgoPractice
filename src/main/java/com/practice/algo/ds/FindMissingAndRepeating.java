package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an unsorted array of size N of positive integers.
 * One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array.
 * Find these two numbers.
 * <p>
 * Example:
 * Input:
 * 2
 * 2
 * 2 2
 * 3
 * 1 3 3
 * <p>
 * Output:
 * 2 1
 * 3 2
 */
public class FindMissingAndRepeating {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0 && testCount % 2 == 0) {
                numberOfSquare(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            testCount++;
        }
    }

    private static void numberOfSquare(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[Math.abs(input[i]) - 1] > 0) {
                input[Math.abs(input[i]) - 1] = -input[Math.abs(input[i]) - 1];
            } else {
                System.out.print(Math.abs(input[i]) + " ");
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                System.out.println(i + 1);
                break;
            }
        }
    }


}
