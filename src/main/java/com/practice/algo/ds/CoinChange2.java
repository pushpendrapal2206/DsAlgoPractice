package com.practice.algo.ds;

import java.util.Arrays;

public class CoinChange2 {
    
    public static void  main(String[] s) {
        int ans = new CoinChange2().coinChange(new int[] {2,5,10,1}, 27);
        System.out.println(ans);
    }
    
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        for(int i = 0; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < coins[i]) {
                    if(i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if(j == coins[i]) {
                    dp[i][j] = 1;
                } else {
                    if(i == 0) {
                        dp[i][j] = dp[i][j - coins[i]] == Integer.MAX_VALUE ? dp[i][j - coins[i]] : 1 + dp[i][j - coins[i]];
                    } else {
                        int t = i;
                        while(t >= 0 && dp[t][j - coins[i]] == Integer.MAX_VALUE) {
                            t--;
                        }
                        if(t >= 0) {
                            dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[t][j - coins[i]]);
                        }
                    }
                }
            }
        }
        return dp[coins.length - 1][amount];
    }
}
