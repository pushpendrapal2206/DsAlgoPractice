package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] arr_A1 = br.readLine().split(" ");
        long A = Long.parseLong(arr_A1[0]);
        long B = Long.parseLong(arr_A1[1]);
        long out_ = solve(A, B);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static long solve(long A, long B) {
        for (long i = 3; i <= A; i += 2) {
            while (A % i == 0) {
                if (B % i == 0) return i;
                A /= i;
            }
        }
        return -1;
    }
}
