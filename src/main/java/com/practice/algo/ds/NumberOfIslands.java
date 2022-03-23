package com.practice.algo.ds;

public class NumberOfIslands {
    
    public static void main(String[] s) {
        char[][] input = new char[][]{
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}};
        System.out.println(new NumberOfIslands().numOfIslands(input));
    }
    
    public int numOfIslands(char[][] grid) {
        if(grid.length < 1) {
            return 0;
        }
        char[][] A = new char[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = 0; j <= A[i].length - 1; j++) {
                if(i==0 || i == A.length - 1 || j==0 || j == A[0].length -1) {
                    A[i][j] = '0';
                } else {
                    A[i][j] = grid[i-1][j-1];
                }
            
            }
        }
        int count = 0;
        boolean[][] visited = new boolean[A.length][A[0].length];
        for (int i = 1; i < A.length - 1; i++) {
            for (int j = 1; j < A[i].length - 1; j++) {
                if (A[i][j] == '1') {
                    visited[i][j] = true;
                    if (    (A[i - 1][j] == '0' || (A[i - 1][j] == '1' && !visited[i-1][j])) &&
                            (A[i + 1][j] == '0' || (A[i + 1][j] == '1' && !visited[i + 1][j])) &&
                            (A[i][j + 1] == '0' || (A[i][j + 1] == '1' && !visited[i][j + 1])) &&
                            (A[i][j - 1] == '0' || (A[i][j - 1] == '1' && !visited[i][j - 1]))) {
                        count++;
                    }
                    if (A[i - 1][j] == '1') {
                        visited[i - 1][j] = true;
                    }
                    if (A[i + 1][j] == '1') {
                        visited[i + 1][j] = true;
                    }
                    if (A[i][j + 1] == '1') {
                        visited[i][j + 1] = true;
                    }
                    if (A[i][j - 1] == '1') {
                        visited[i][j - 1] = true;
                    }
                }
            }
        }
        return count;
    }
}
