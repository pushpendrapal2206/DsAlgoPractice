package com.practice.algo.ds;

import java.util.Arrays;

/**
 * Reorder an array with both negative and positive numbers to place all negatives first,
 * followed by positives — in-place.
 * <p>
 * [-10,-2, 3,4,-2,-12,5,6,7,6, -1,-4,-8,-3]
 * pli = 2
 */
public class ReorderArray {
    public int[] reorderArray(int[] input) {
        int pli = -1;
        for (int i = 0; i < input.length; i++) {
            if (pli == -1 && input[i] >= 0) {
                pli = i;
            }
            if (pli != -1 && input[i] < 0) {
                int temp = input[pli];
                input[pli] = input[i];
                input[i] = temp;
                pli++;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] output = new ReorderArray().reorderArray(new int[]{});
        System.out.println(Arrays.toString(output));
    }
}
