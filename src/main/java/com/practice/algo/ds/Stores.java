package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

public class Stores {
    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        int output = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid.get(i).get(j) == 1) {
                    if (i < rows - 1 && j < column - 1 &&
                            grid.get(i).get(j + 1) == 0 &&
                            grid.get(i + 1).get(j) == 0) {
                        output++;
                    }
                    if (i == rows - 1 || j == column - 1) {
                        output++;
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] s) {
        List<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(1);
        input1.add(0);
        input1.add(1);
        List<Integer> input2 = new ArrayList<>();
        input2.add(0);
        input2.add(0);
        input2.add(1);
        input2.add(0);
        List<Integer> input3 = new ArrayList<>();
        input3.add(0);
        input3.add(0);
        input3.add(0);
        input3.add(0);
        List<Integer> input4 = new ArrayList<>();
        input4.add(1);
        input4.add(0);
        input4.add(1);
        input4.add(1);
        List<Integer> input5 = new ArrayList<>();
        input5.add(1);
        input5.add(1);
        input5.add(1);
        input5.add(1);
        List<List<Integer>> input = new ArrayList<>();
        input.add(input1);
        input.add(input2);
        input.add(input3);
        input.add(input4);
        input.add(input5);
        System.out.println(new Stores().numberAmazonGoStores(5, 4, input));
    }
}
