package com.practice.algo.ds;

public class Targetsum {
    
    public static void main(String[] s) {
        System.out.println(new Targetsum().findTargetSumWays(new int[] {0,0,0,0,0,0,0,0,1}, 1));
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0 ;
        }
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum < target) {
            return 0;
        }
        
        int nt = (sum + target) / 2;
        
        int[][] dp = new int[nums.length + 1][nt + 1];
        
        for(int k = 0; k < dp[0].length; k++) {
            if(k == 0) {
                dp[0][k] = 1;
            } else {
                dp[0][k] = 0;
            }
            if(k <= nums.length) {
                dp[k][0] = 1;
            }
        }
    
        for(int i = 1; i < dp.length; i ++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < nums[i -1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i -1]];
                }
            
            }
        }
        return dp[nums.length][nt];
    }
}
