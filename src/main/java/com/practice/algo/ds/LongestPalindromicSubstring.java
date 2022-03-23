package com.practice.algo.ds;


/**
 * Input: input = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * s= 0
 * e= len-1 =  4
 * input[s] == input[e]
 * ml = 2
 * s++
 * e--
 * lps(s) = lps(s[1], s[len-2])
 * babad
 * b!=d                                    b=d
 * babb          abbd                        abb
 * <p>
 * <p>
 * babad
 * pl=1                        b
 * pl=1                   ab               ba
 * pl= 3                       aba       bad    aba       bad
 * abad       baba abad    abad
 */
public class LongestPalindromicSubstring {
    
    public static void main(String[] s) {
        System.out.println(longestPalindrom("aacabdkacaa"));
    }
    
    public static String longestPalindrom(String input) {
        int len = input.length();
        boolean[][] dp = new boolean[len][len];
        String lp = "";
        for (int g = 0; g < input.length(); g++) {
            for (int i = 0, j = g; j < input.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                }
                if (g == 1) {
                    dp[i][j] = input.charAt(i) == input.charAt(j);
                }
                if (g > 1) {
                    dp[i][j] = input.charAt(i) == input.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    lp = input.substring(i, j + 1);
                }
            }
        }
        return lp;
    }
}
