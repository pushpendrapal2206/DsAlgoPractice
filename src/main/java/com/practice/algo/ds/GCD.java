package com.practice.algo.ds;

class GCD {

    public int generalizedGCD(int num, int[] arr) {
        int output = arr[0];
        for (int i = 1; i < num; i++) {
            output = gcd(arr[i], output);
        }
        return output;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] s) {
        System.out.println(new GCD().generalizedGCD(5, new int[]{2, 4, 6, 8, 10}));
    }
}
