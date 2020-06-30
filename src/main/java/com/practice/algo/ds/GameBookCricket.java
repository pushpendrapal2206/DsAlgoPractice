package com.practice.algo.ds;

public class GameBookCricket {
    public static void main(String[] s) {
        System.out.println(noOfWaysToDrawTheGame(10));
    }

    private static int noOfWaysToDrawTheGame(int totalScore) {
        if (totalScore % 2 != 0) {
            return 0;
        } else if (totalScore == 0) {
            return 0;
        }
        if (totalScore == 2) {
            return 1;
        } else if (totalScore == 4) {
            return 2;
        } else if (totalScore == 6) {
            return 4;
        }
        return noOfWaysToDrawTheGame(totalScore - 2) +
                noOfWaysToDrawTheGame(totalScore - 4) +
                noOfWaysToDrawTheGame(totalScore - 6);
    }
}
