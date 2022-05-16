package com.practice.algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 "leetcode", wordDict = ["leet","code"]
        l e e t c o d e
   leet f f f t f f f f
   code f f f f f f f t
 
                                                                leetcode
                                                        leet code       leetc ode
                                                             c ode
 */

public class WordBreak {
    private Map<String, Boolean> map = new HashMap<>();
    public static void main(String[] s) {
        boolean ans = new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        System.out.println(ans);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || s.length() == 1) {
            return wordDict.contains(s);
        }
        if(wordDict.size() == 0) {
            return false;
        }
        
        return match(s, new HashSet<>(wordDict), "");
    }
    
    public boolean match(String input, Set<String> wordDict, String msf) {
        if(map.containsKey(input)) {
            return map.get(input);
        }
        if(wordDict.contains(input)) {
            map.put(input, true);
            if(msf.length() == 0 || wordDict.contains(msf)) {
                map.put(msf , wordDict.contains(msf));
                return true;
            }
        }
        if(input.length() == 0) {
            boolean out = wordDict.contains(msf);
            map.put(msf, out);
            return out;
        }
        if(wordDict.contains(msf)) {
            map.put(msf, true);
            return match(input, wordDict, "") || match(input.substring(1), wordDict, msf + input.charAt(0));
        } else {
            return match(input.substring(1, input.length()), wordDict, msf + input.charAt(0));
        }
    }
}
