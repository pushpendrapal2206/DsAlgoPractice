package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Find total number of Squares in a N*N cheesboard.
 * <p>
 * Example:
 * Input:
 * 2
 * 1
 * 2
 * <p>
 * Output:
 * 1
 * 5
 */
public class Chessboard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0) {
                System.out.println(numberOfSquare(Integer.parseInt(line)));
            }
            testCount++;
        }
    }

    private static int numberOfSquare(int input) {
        if (input == 0) {
            return 0;
        }
        return input * input + numberOfSquare(input - 1);
    }


}
