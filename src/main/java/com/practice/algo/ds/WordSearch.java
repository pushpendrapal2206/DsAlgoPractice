package com.practice.algo.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordSearch {
    
    public static void main(String[] s) {
        char[][] board = new char[][] {
                {'A', 'B'},
                {'C', 'D'}
        };
        System.out.println(new WordSearch().exist(board, "ABDC"));
    }
    
    public boolean exist(char[][] board, String word) {
        int wl = word.length();
        Stack<Integer[]> stack = new Stack<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int k = 0;
                boolean[][] visited = new boolean[board.length][board[0].length];
                stack.push(new Integer[]{i, j});
                while(stack.size() > 0) {
                    Integer[] indexes = stack.peek();
                    int pi = indexes[0];
                    int pj = indexes[1];
                    if(visited[pi][pj]
                            && (pi + 1) < board.length && visited[pi+1][pj]
                            && (pi - 1) >= 0 && visited[pi-1][pj]
                            && (pj - 1) >= 0 && visited[pi][pj-1]
                            && (pj + 1) < board[0].length
                            && visited[pi][pj+1]) {
                        Integer[] idxs = stack.pop();
                        if(k>0) {
                            k--;
                        }
//                        int poi = idxs[0];
//                        int poj = idxs[1];
//                        if((poi >= 0 && poj < board[0].length) && k > 0 && word.charAt(k - 1) == board[poi][poj]) {
//                            k--;
//                        }
                        continue;
                    }
                    if(board[pi][pj] == word.charAt(k)) {
                        visited[pi][pj] = true;
                        k++;
                        if((pi + 1) < board.length
                                && !(map.containsKey(board[pi][pj]) && map.get(board[pi][pj]).contains(board[pi+1][pj]))) {
                            stack.push(new Integer[]{pi+1, pj});
                            map.computeIfAbsent(board[pi][pj], s -> new HashSet<Character>()).add(board[pi+1][pj]);
                        } else if((pi - 1) >= 0
                                && !(map.containsKey(board[pi][pj]) && map.get(board[pi][pj]).contains(board[pi-11][pj]))) {
                            stack.push(new Integer[]{pi-1, pj});
                            map.computeIfAbsent(board[pi][pj], s -> new HashSet<Character>()).add(board[pi-1][pj]);
                        } else if((pj - 1) >= 0
                                && !(map.containsKey(board[pi][pj]) && map.get(board[pi][pj]).contains(board[pi][pj-1]))) {
                            stack.push(new Integer[]{pi, pj-1});
                            map.computeIfAbsent(board[pi][pj], s -> new HashSet<Character>()).add(board[pi][pj-1]);
                        } else if((pj + 1) < board[0].length
                                && !(map.containsKey(board[pi][pj]) && map.get(board[pi][pj]).contains(board[pi][pj+1]))) {
                            stack.push(new Integer[]{pi, pj+1});
                            map.computeIfAbsent(board[pi][pj], s -> new HashSet<Character>()).add(board[pi][pj+1]);
                        }
                    } else {
                        Integer[] idxs = stack.pop();
                        if(k>0) {
                            k--;
                        }
//                        int poi = idxs[0];
//                        int poj = idxs[1];
//                        if((poi >= 0 && poj < board[0].length) && k > 0 && word.charAt(k - 1) == board[poi][poj]) {
//                            k--;
//                        }
                    }
                    if(k == wl) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
