package com.practice.algo.ds;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ActiveInactiveCells {

    public List<Integer> cellCompete(int[] states, int days) {
        int[] temp = new int[states.length];
        for (int j = 0; j < states.length; j++) {
            temp[j] = states[j];
        }
        while (days > 0) {
            for (int i = 0; i < states.length; i++) {
                if (i == 0) {
                    temp[i] = states[i + 1];
                } else if (i == (states.length - 1)) {
                    temp[i] = states[i - 1];
                } else {
                    temp[i] = states[i - 1] ^ states[i + 1];
                }
            }
            for (int j = 0; j < states.length; j++) {
                states[j] = temp[j];
            }
            days--;
        }
        return Arrays.stream(temp).boxed().collect(Collectors.toList());
    }

    public static void main(String[] s) {
        System.out.print(new ActiveInactiveCells().cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2));
    }
}