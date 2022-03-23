package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    public static void main(String[] s) {
        WordDictionary node = new WordDictionary();
        node.addWord("xgvk");
        node.addWord("fkqclfmvzpzpnbvz");
        System.out.println(node.search(".g.."));
        System.out.println(node.search(".kqclfmvzpzpnbvz"));
    }
    
    private Map<Character, WordDictionary> node;
    private boolean isLast;
    
    public WordDictionary() {
        this.node = new HashMap<>();
        this.isLast = false;
    }
    
    public void addWord(String word) {
        WordDictionary temp = this;
        for (char c : word.toCharArray()) {
            if (!temp.node.containsKey(c)) {
                temp.node.put(c, new WordDictionary());
            }
            if(!temp.node.containsKey('.')) {
                temp.node.put('.', temp.node.get(c));
            }
            temp = temp.node.get(c);
        }
        temp.isLast = true;
    }
    
    public boolean search(String word) {
        WordDictionary temp = this;
        for (char c : word.toCharArray()) {
            if (!temp.node.containsKey(c)) {
                return false;
            }
            temp = temp.node.get(c);
        }
        return temp.isLast;
    }
}
