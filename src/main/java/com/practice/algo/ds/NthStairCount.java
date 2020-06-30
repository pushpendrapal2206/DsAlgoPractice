package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthStairCount {
    static int[] storage;

    public static void main(String[] s) throws IOException {
        storage = new int[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0) {
                System.out.println(countOfStairs(Integer.parseInt(line)));
            }
            testCount++;
        }
    }

    private static int countOfStairs(int input) {
        if (input == 1) {
            storage[input - 1] = 1;
            return 1;
        }
        if (input % 2 != 0) {
            if (storage[input - 1] != 0) {
                storage[input - 1] = storage[input - 2];
                return storage[input - 1];
            }
            storage[input - 1] = countOfStairs(input - 1);
            return storage[input - 1];
        } else {
            if (storage[input - 1] != 0) {
                storage[input - 1] = 1 + storage[input - 2];
                return storage[input - 1];
            }
            storage[input - 1] = 1 + countOfStairs(input - 1);
            return storage[input - 1];
        }
    }
}
