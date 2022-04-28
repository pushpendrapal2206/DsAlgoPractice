package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheapestFlight {
    int cost = Integer.MAX_VALUE;
    
    public static void main(String[] s) {
        int c = new CheapestFlight().findCheapestPrice(10, new int[][] {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}},
                6,0,7);
        
        System.out.println(c);
    }
    
    
    public static class Test {
        int source;
        int destination;
        int price;
        
        public Test(int source, int dest, int price) {
            this.source = source;
            this.destination = dest;
            this.price = price;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Test>> map = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            map.computeIfAbsent(flights[i][0], z -> new ArrayList<>()).add(new Test(flights[i][0], flights[i][1], flights[i][2]));
        }
        boolean[] visited = new boolean[n];
        dfs(src, map, k, visited, dst, 0);
        if (cost == Integer.MAX_VALUE) {
            return -1;
        }
        return cost;
    }
    
    public void dfs(int s, Map<Integer, List<Test>> graph, int k, boolean[] visited, int dest, int csf) {
        if (visited[s]) {
            return;
        }
        if (k < 0) {
            return;
        }
        if (s == dest) {
            cost = Math.min(cost, csf);
            return;
        }
        if (cost < csf) {
            return;
        }
        
        visited[s] = true;
        if (graph.get(s) != null) {
            for (Test t : graph.get(s)) {
                if (t.destination != dest) {
                    dfs(t.destination, graph, k - 1, visited, dest, csf + t.price);
                } else {
                    dfs(t.destination, graph, k, visited, dest, csf + t.price);
                }
            }
        }
        visited[s] = false;
    }
}
