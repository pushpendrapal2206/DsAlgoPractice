package com.practice.algo.ds;

/**
 *      0   1    2   3
 * R   10  19   33   26
 * G   9   16   25   28
 * B   18  110  23   43
 *
 * min[9, 10, 9]
 * l = 18
 * r = 10
 * 10, 9, 18
 * 9, 10, 9
 */
public class PaintHouse {
    
    public static void main(String[] s) {
        int cost = new PaintHouse().minCostOfPaint(new int[][]{
                {10, 10, 17, 3},
                {9,  6,   6, 5},
                {18, 101, 7, 18}
        });
        
        System.out.println(cost);
    }
    
    public int minCostOfPaint(int[][] input) {
        int[] dp = new int[input.length];
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < input[0].length; j++) {
            minCost = Integer.MAX_VALUE;
            int[] dpcl = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                if (j == 0) {
                    dp[i] = input[i][j];
                } else {
                    if (i == 0) {
                        dpcl[i] = Math.min(dp[i + 1], dp[i + 2]) + input[i][j];
                    } else if (i == input.length - 1) {
                        dpcl[i] = Math.min(dp[i - 1], dp[i - 2]) + input[i][j];
                    } else {
                        dpcl[i] = Math.min(dp[i - 1], dp[i + 1]) + input[i][j];
                    }
                }
                minCost = Math.min(minCost, dpcl[i]);
            }
            if(j != 0) {
                dp = dpcl;
            }
            
        }
        return minCost;
    }
}
