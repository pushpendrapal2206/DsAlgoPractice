package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of strings products and a string searchWord.
 * <p>
 * Design a system that suggests at most three product names from products after each character of searchWord is typed.
 * Suggested products should have common prefix with searchWord.
 * If there are more than three products with a common prefix return the three lexicographically minimums products.
 * <p>
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
 * Example 2:
 * <p>
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Explanation: The only word "havana" will be always suggested while typing the search word.
 */
public class SearchSuggestionSystem {

    public  static void main(String[] s) {
        new SearchSuggestionSystem().suggestedProducts(new String[] {"mobile", "moneypot"}, "me");
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.addWord(product);
        }
        System.out.println(trie.prefixSearch("mob"));

        return null;
    }

    public static class Trie {
        Map<Character, Trie> node;
        boolean isEnd;

        public Trie() {
            this.node = new HashMap<>();
            this.isEnd = false;
        }

        public void addWord(String word) {
            Trie temp = this;
            for (char c : word.toCharArray()) {
                if (!temp.node.containsKey(c)) {
                    temp.node.put(c, new Trie());
                }
                temp = temp.node.get(c);
            }
            temp.isEnd = true;
        }

        public List<String> prefixSearch(String prefix) {
            /**
             *              mobile","moneypot"
             *              prefix -> mo
             *              f    f    f    f    f    t
             *              m -> o -> b -> i -> l -> e -> null
             *                        n -> e -> y -> p -> o -> t -> null
             *              f    f    f    f    f    f    f    t
             */
            Trie temp = this;
            List<String> list = new ArrayList<>();
            for (char c : prefix.toCharArray()) {
                if(!temp.node.containsKey(c)) {
                   return list;
                }
                temp = temp.node.get(c);
            }
            searchWord(temp, list, new StringBuilder(prefix));
            return list;
        }

        private void searchWord(Trie trie, List<String> matchedWords, StringBuilder sb) {
            if(trie.isEnd) {
                matchedWords.add(sb.toString());
            }
            for(Map.Entry<Character, Trie> entry: trie.node.entrySet()) {
                sb.append(entry.getKey());
                searchWord(entry.getValue(), matchedWords, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
