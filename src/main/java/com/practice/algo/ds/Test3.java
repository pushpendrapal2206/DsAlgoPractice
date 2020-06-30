package com.practice.algo.ds;

public class Test3 {

    public int solution(int[] A, int S) {
        int numberOfFragments = 0;
        int currentEle = S;
        int nextEle = S;
        int start = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == nextEle) {
                numberOfFragments++;
            } else {
                nextEle = S + nextEle - A[i];
            }
            while (start != i) {
                start++;
//                if ()
            }
        }
        return numberOfFragments;
    }

    public static void main(String[] str) {

    }
}
