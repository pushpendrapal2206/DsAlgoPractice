package com.practice.algo.ds;

import java.util.*;

public class NumberOfIslands2 {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        if (operators.length == 0) {
            return new ArrayList<>();
        }
        int[] dp = new int[operators.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        dp[0] = 1;
        int pi = 0;
        for (Point p : operators) {
            updateMap(p, map, n, m);
            if (pi != 0) {
                if (map.get(p.x) != null && map.get(p.x).contains(p.y)) {
                    dp[pi] = dp[pi - 1];
                } else {
                    dp[pi] = 1 + dp[pi - 1];
                }
            }
            pi++;
        }
        List<Integer> result = new ArrayList<>();
        for (int r : dp) {
            result.add(r);
        }
        return result;
    }

    private void updateMap(Point p, Map<Integer, Set<Integer>> map, int n, int m) {
        int[][] d = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] id : d) {
            int di = p.x + id[0];
            int dj = p.y + id[1];
            if (di >= 0 && dj >= 0 && di < n && dj < m) {
                map.computeIfAbsent(di, z -> new HashSet<>()).add(dj);
            }
        }
    }

    public static void main(String[] s) {
        NumberOfIslands2 ni = new NumberOfIslands2();
        Point[] points = new Point[4];
        int[][] arr = new int[][]{{1, 1}, {0, 1}, {3, 3}, {3, 4}};
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(arr[i][0], arr[i][1]);
        }
        List<Integer> result = ni.numIslands2(4, 5, points);
        System.out.println(result);
    }
}
