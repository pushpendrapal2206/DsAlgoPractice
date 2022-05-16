package com.practice.algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for(int c : coins) {
            map.put(c, true);
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++) {
            if(map.containsKey(i)) {
                dp[i] = 1;
            } else {
                int t = i - 1;
                while(t > 0) {
                    if(i % t == 0) {
                        if(dp[t] != Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], (i / t) * dp[t]);
                        }
                    } else {
                        if(dp[t] != Integer.MAX_VALUE && dp[i % t] != Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], (i / t) * dp[t] + dp[i % t]);
                        }
                    }
                    t--;
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
