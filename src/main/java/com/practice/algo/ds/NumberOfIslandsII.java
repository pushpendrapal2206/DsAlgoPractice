package com.practice.algo.ds;

import java.util.*;

/**
 * Description
 * Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.You need to return an array of size K.
 * <p>
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
 * Output: [1,1,2,2]
 * Explanation:
 * 0.  00000
 * 00000
 * 00000
 * 00000
 * 1.  00000
 * 01000
 * 00000
 * 00000
 * 2.  01000
 * 01000
 * 00000
 * 00000
 * 3.  01000
 * 01000
 * 00000
 * 00010
 * 4.  01000
 * 01000
 * 00000
 * 00011
 * Example 2:
 * <p>
 * Input: n = 3, m = 3, A = [[0,0],[0,1],[2,2],[2,1]]
 * Output: [1,1,2,2]
 */
public class NumberOfIslandsII {
    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> islands = new ArrayList<>();
        int count = 0;
        for (Point p : operators) {
            if (!(map.containsKey(p.x) && map.get(p.x).contains(p.y))) {
                count++;
                map.computeIfAbsent(p.x, z -> new HashSet()).add(p.y);
                if (p.x >= 1) {
                    map.computeIfAbsent(p.x - 1, z -> new HashSet()).add(p.y);
                }
                if (p.x < n - 1) {
                    map.computeIfAbsent(p.x + 1, z -> new HashSet()).add(p.y);
                }
                if (p.y >= 1) {
                    map.computeIfAbsent(p.x, z -> new HashSet()).add(p.y - 1);
                }
                if (p.y < m - 1) {
                    map.computeIfAbsent(p.x, z -> new HashSet()).add(p.y + 1);
                }
            }
            islands.add(count);
        }
        return islands;
    }

    public static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(3, 3);
        Point point4 = new Point(3, 4);
    }
}
