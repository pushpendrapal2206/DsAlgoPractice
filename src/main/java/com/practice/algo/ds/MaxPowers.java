package com.practice.algo.ds;

/**
 * powers = [2,3,10, 8,7,1,20]
 * select 2 3 12 11 19 13 39
 * leave  0 2 3  12 12 19 19
 */
public class MaxPowers {
    public int maxPower(int[] powers) {
        int pps = powers[0];
        int ppns = 0;

        for (int i = 1; i < powers.length; i++) {
            int cpps = ppns + powers[i];
            int cppns = Math.max(ppns, pps);
            pps = cpps;
            ppns = cppns;
        }
        return Math.max(pps, ppns);
    }

    public static void main(String[] args) {
        int maxp = new MaxPowers().maxPower(new int[]{2, 3, 10, 8, 7, 1, 20});
        System.out.println(maxp);
    }
}
