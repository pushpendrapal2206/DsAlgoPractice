package com.practice.algo.ds;

/**
 * Description
 * In this problem, there is an undirected graph with n nodes. There is also an edges array. Where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
 * <p>
 * You need to return the number of connected components in that graph.
 * <p>
 * Example
 * Example 1
 * <p>
 * Input:
 * <p>
 * 3
 * [[0,1], [0,2]]
 * Output:
 * <p>
 * 1
 * Example 2
 * <p>
 * Input:
 * <p>
 * 6
 * [[0,1], [1,2], [2, 3], [4, 5]]
 * Output:
 * <p>
 * 2
 */
public class NumberOfConnectedComponents {
    public static int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                drawTree(i, edges, visited);
                count++;
            }
        }
        return count;
    }

    public static void drawTree(int i, int[][] edges, boolean[] visited) {
        visited[i] = true;
        for (int[] edge : edges) {
            if (edge[0] == i) {
                if (!visited[edge[1]]) {
                    drawTree(edge[1], edges, visited);
                }
            }
        }
    }

    public static void main(String[] main) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 5}};
        System.out.println("Number of connected components: " + countComponents(6, edges));
    }
}
