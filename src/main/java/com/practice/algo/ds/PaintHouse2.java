package com.practice.algo.ds;

import java.util.Arrays;

/**
 *      0   1    2   3
   R   10  10   17  3
   G   9   6    6   5
   B   18  101  7  18

 * *      0   1    2   3
 *  * R   10  19   33   26
 *  * G   9   16   25   28
 *  * B   18  110  23   43
 *    [33, 25, 23]
 * min[*, 23, *]
 * l = 25
 * r = 23
 * 10, 9, 18
 * *
 */
public class PaintHouse2 {
    
    public static void main(String[] s) {
        int cost = new PaintHouse2().minCostOfPaint(new int[][]{
                {10, 10, 17, 3},
                {9,  6,   6, 5},
                {18, 101, 7, 18}
        });
        
        System.out.println(cost);
    }
    
    public int minCostOfPaint(int[][] input) {
        int minCost = Integer.MAX_VALUE;
        int[] minArr = new int[input.length];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        for (int j = 0; j < input[0].length; j++) {
            int l = Integer.MAX_VALUE;
            int r = Integer.MAX_VALUE;
            for (int i = 0; i < input.length; i++) {
                if(j != 0) {
                    input[i][j] = minArr[i] + input[i][j];
                }
                if(j == input[0].length - 1) {
                    minCost = Math.min(minCost, input[i][j]);
                }
            }
            Arrays.fill(minArr, Integer.MAX_VALUE);
            for (int i = 0; i < input.length; i++) {
                minArr[i] = Math.min(l, minArr[i]);
                l = Math.min(l, input[i][j]);
                minArr[input.length - 1 - i] = Math.min(r, minArr[input.length - 1 - i]);
                r = Math.min(r, input[input.length - 1 - i][j]);
            }
        }
        return minCost;
    }
}
