package com.practice.algo.ds;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
//[[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]] ,5
// [2,4], [2,5], [4,5], [5,6]
// 2, 5, 4
//[0,1][1,0] 0
// 0

public class CourseSchedule2 {
    
    public static void main(String[] s) {
        int[][] input = {
                {0,1},
                {0,2},
                {1,2}
        };
       int[] output = new CourseSchedule2().findOrder(3, input);
       System.out.println(output[0] + " " + output[1]);
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
    
        for (int[] prerequisite : prerequisites) {
            map.computeIfAbsent(prerequisite[0], z -> new ArrayList<Integer>()).add(prerequisite[1]);
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack();
    
        if(isCycle(map, numCourses)) {
            return new int[] {};
        }
        
        for(int i=0; i < numCourses; i++) {
            if(!visited[i]) {
                topologicalSort(i, map, visited, stack);
            }
        }
        
        int[] output = new int[numCourses];
        for(int i = numCourses - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }
        return output;
    }
    
    public boolean isCycle(Map<Integer, List<Integer>> graph, int numCourses) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            queue.add(i);
            while (!queue.isEmpty()) {
                int key = queue.poll();
                if(visited[key] && graph.containsKey(key)) {
                    return true;
                } else {
                    visited[key] = true;
                    if(graph.containsKey(key)) {
                        for(int k : graph.get(key)) {
                                if(!queue.contains(k)) {
                                    queue.add(k);
                                }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void topologicalSort(int v, Map<Integer, List<Integer>> graph,  boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        if(graph.containsKey(v)) {
            for(int neighbor : graph.get(v)) {
                if(!visited[neighbor]) {
                    topologicalSort(neighbor, graph, visited, stack);
                }
            }
        }
        stack.push(v);
    }
}
