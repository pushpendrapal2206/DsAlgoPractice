package com.practice.algo.ds;

public class FindSmallestNumber {


    public int solution(int N) {
        int input = N;
        int output = 0;
        if (input >= 10) {
            output = 1;
        }
        while (input > 0) {
            input = input / 10;
            if (input != 0) {
                output = output * 10;
            }
        }
        return output;
    }

    public static void main(String s[]) {
        System.out.println(new FindSmallestNumber().solution(9));
    }
}
