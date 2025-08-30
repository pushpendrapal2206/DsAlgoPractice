package com.practice.algo.ds;

import java.util.*;

public class PracticeGraph {

    public void bfs(Graph g, int root) {
        if (g == null) {
            return;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            System.out.println(polled);
            queue.addAll(g.getNeighbours(polled));
        }
    }

    public static class Graph {
        private final Map<Integer, List<Integer>> adj;

        public Graph() {
            this.adj = new HashMap<>();
        }

        public void addEdge(int u, int v) {
            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
        }

        public List<Integer> getNeighbours(int u) {
            return adj.getOrDefault(u, new ArrayList<>());
        }
    }
}
