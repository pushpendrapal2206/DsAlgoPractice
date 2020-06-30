package com.practice.algo.ds;

public class BestFitBox {
    public static int fitBoxSize(int[] boxes, int size) {
        for (int i = 0; i < boxes.length; i++) {
            if (size <= boxes[i]) {
                return boxes[i];
            }
        }
        return -1;
    }

    public static void main(String s[]) {
        System.out.print(fitBoxSize(new int[]{10, 50, 70, 100, 110}, 75));
    }
}
