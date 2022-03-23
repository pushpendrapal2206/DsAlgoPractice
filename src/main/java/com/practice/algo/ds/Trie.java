package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

class Trie {
    public static void main(String[] s) {
        Trie node = new Trie();
        node.insert("apple");
       System.out.println(node.search("apple"));
       System.out.println(node.search("app"));
    }
    
    private Map<Character, Trie> map;
    private boolean isLast;
    public Trie() {
        this.map = new HashMap<>();
        this.isLast = false;
    }
    
    public void insert(String word) {
        Trie temp = this;
        for(char c : word.toCharArray()) {
            if(temp.map.containsKey(c)) {
                temp = temp.map.get(c);
            } else {
                temp.map.put(c, new Trie());
                temp = temp.map.get(c);
            }
        }
        temp.isLast = true;
    }
    
    public boolean search(String word) {
        Trie temp = this;
        for(char c : word.toCharArray()) {
            if(!temp.map.containsKey(c)) {
                return false;
            }
            temp = temp.map.get(c);
        }
        return temp.isLast;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(char c : prefix.toCharArray()) {
            if(!temp.map.containsKey(c)) {
                return false;
            }
            temp = temp.map.get(c);
        }
        return true;
    }
}
