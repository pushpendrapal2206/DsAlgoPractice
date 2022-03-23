package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class RegularExpression {
    public static void main(String[] s) {
        System.out.println(new RegularExpression().isMatch("bbbba", ".*a*a"));
    }
    
    public class Trie {
        private Map<Character, Trie> map;
        private boolean isLast;
        
        public Trie() {
            this.map = new HashMap<>();
            this.isLast = false;
        }
    }
    
    public boolean isMatch(String s, String p) {
        Trie trie = new RegularExpression().new Trie();
        Trie curr = trie;
        for (char c : s.toCharArray()) {
            curr.map.put(c, new RegularExpression().new Trie());
            curr.map.put('.', curr.map.get(c));
            curr.map.put('*', curr.map.get(c));
            curr = curr.map.get(c);
        }
        curr.isLast = true;
        
        Trie temp = trie;
        int traversed = 0;
        for (int j = 0; j< p.length(); j++) {
            char c = p.charAt(j);
            if (!temp.map.containsKey(c)) {
                if((j+1) <= p.length() - 1 && p.charAt(j + 1) == '*') {
                    j++;
                } else {
                    traversed++;
                    return false;
                }
            } else if((j+1) <= p.length() - 1 && p.charAt(j + 1) == '*') {
                temp = temp.map.get(c);
                traversed++;
                int remainingElements = p.length() - j - 2;
                int elementsToBeTraversed = s.length() - remainingElements;
                while(temp.map.containsKey(c) && elementsToBeTraversed > traversed) {
                    temp = temp.map.get(c);
                    traversed++;
                }
                j++;
            } else if (c == '*') {
                while (temp.map.size() > 0) {
                    temp = temp.map.get(c);
                    traversed++;
                }
            } else {
                if(temp.map.get(c) != null) {
                    temp = temp.map.get(c);
                    traversed++;
                }
            }
        }
        return temp.isLast;
    }
}
