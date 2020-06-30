package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

public class SwapDiagonalElements {


    public static void swapDiagonal(List<List<Integer>> matrix) {
        int i = 0;
        int j = matrix.size() - 1;

        while (i <= matrix.size() - 1 && j >= 0) {
            int temp = matrix.get(i).get(i);
            matrix.get(i).set(i, matrix.get(i).get(j));
            matrix.get(i).set(j, temp);
            i++;
            j--;
        }

        try {
            System.out.println("try");
            throw new Exception("some");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println(matrix);
    }

    public static void main(String[] s) {

        List<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(45);
        input1.add(1);
        input1.add(8);
        input1.add(2);
        input1.add(0);
        List<Integer> input2 = new ArrayList<>();
        input2.add(5);
        input2.add(87);
        input2.add(3);
        input2.add(8);
        input2.add(2);
        input2.add(8);
        List<Integer> input3 = new ArrayList<>();
        input3.add(9);
        input3.add(5);
        input3.add(8);
        input3.add(8);
        input3.add(9);
        input3.add(0);
        List<Integer> input4 = new ArrayList<>();
        input4.add(7);
        input4.add(4);
        input4.add(1);
        input4.add(10);
        input4.add(2);
        input4.add(1);
        List<Integer> input5 = new ArrayList<>();
        input5.add(6);
        input5.add(2);
        input5.add(6);
        input5.add(8);
        input5.add(20);
        input5.add(0);
        List<Integer> input6 = new ArrayList<>();
        input6.add(1);
        input6.add(32);
        input6.add(5);
        input6.add(8);
        input6.add(7);
        input6.add(9);
        List<List<Integer>> input = new ArrayList<>();
        input.add(input1);
        input.add(input2);
        input.add(input3);
        input.add(input4);
        input.add(input5);
        input.add(input6);
        swapDiagonal(input);
    }
}
