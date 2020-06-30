package com.practice.algo.ds;

public class LongestValidParenthesis {
    public int lengthOfParenthesis(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int output = 0;
        int start = 0;
        int end = -1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sum--;
            } else if (s.charAt(i) == ')') {
                sum++;
            }
            if (sum == 0) {
                end = i;
                int max = end - start + 1;
                if (max > output) {
                    output = max;
                }
            }
            if (sum > 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return output;
    }

    public static void main(String[] s) {
        System.out.println(new LongestValidParenthesis().lengthOfParenthesis("()(())))(())()()"));
    }
}
