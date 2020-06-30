package com.practice.algo.ds;

public class CalcPower {
    public double power(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (b == 0) {
            return 1;
        }
        int i = b / 2;
        int j = b % 2;
        return power(a, i) * power(a, i) * power(a, j);
    }

    public static void main(String[] s) {
        System.out.println(new CalcPower().power(10, 20));
    }
}
