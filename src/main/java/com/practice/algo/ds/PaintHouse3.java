package com.practice.algo.ds;

import java.util.Arrays;

/**
 *
 * houses = [0,0,0,0,0]
 *          1 2
 * cost = [[1,10],
 *         [10,1],
 *         [10,1],
 *         [1,10],
 *         [5,1]]
 *
 *
 * m = 5, n = 2, target = 3
 *
 * houses = [0,2,1,2,0],
 *
 * cost = [[1,10],
 *         [10,1],
 *         [10,1],
 *         [1,10],
 *         [5,1]],
 *
 * m = 5, n = 2, target = 3
 *
 *
 * houses = [3,1,2,3],
 * cost = [[1,1,1],
 *         [1,1,1],
 *         [1,1,1],
 *         [1,1,1]],
 *
 * m = 4, n = 3, target = 3
 */
public class PaintHouse3 {
    
    public static void main(String[] s) {
        int cost = new PaintHouse3().minCostOfPaint(new int[][]{
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
