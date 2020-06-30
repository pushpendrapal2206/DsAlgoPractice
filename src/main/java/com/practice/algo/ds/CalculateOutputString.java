package com.practice.algo.ds;

/**
 * Given 2 integers u and l and an array  c of n integers. return a string describing the matrix M.
 * in the following format. First part of the output string should be description of the upper row
 * (n characters 0 or 1) then there should be "," and finally there should be description of the lower row.
 * <p>
 * IF there exist multiple valid M's return any one of them. else return "IMPOSSIBLE".
 * <p>
 * E.g Given u=3, l=2 and c={2,1,1,0,1} It can return 11001,10100
 * Given u=2, l=3 and c={2,1,1,0,0} It will return "IMPOSSSIBLE".
 */
public class CalculateOutputString {

    public static void main(String[] s) {
        System.out.println(solution(2, 2, new int[]{2, 0, 2, 0}));
    }

    public static String solution(int u, int l, int[] c) {
        String s1 = "";
        String s2 = "";
        for (int value : c) {
            if (value == 2) {
                if (u > 0) {
                    s1 = s1 + "1";
                    u--;
                }
                if (l > 0) {
                    s2 = s2 + "1";
                    l--;
                }
            } else if (value == 1) {
                if (u > 0) {
                    s1 = s1 + "1";
                    s2 = s2 + "0";
                    u--;
                } else if (l > 0) {
                    s2 = s2 + "1";
                    s1 = s1 + "0";
                    l--;
                }
            } else {
                s1 = s1 + "0";
                s2 = s2 + "0";
            }
        }

        return l == 0 && u == 0 ? s1 + "," + s2 : "IMPOSSIBLE";
    }
}
