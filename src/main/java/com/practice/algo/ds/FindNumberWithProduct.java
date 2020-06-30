package com.practice.algo.ds;

public class FindNumberWithProduct {

    public int solution(int A, int B) {
        int count = 0;
        int j = 1;
        int product = 0;
        while (product <= B) {
            product = j * (j + 1);
            j++;
            if (product <= B && product >= A) {
                count++;
            }
        }
        return count;
    }

    public static void main(String s[]) {
        System.out.println(new FindNumberWithProduct().solution(1, 1000000000));
    }
}
