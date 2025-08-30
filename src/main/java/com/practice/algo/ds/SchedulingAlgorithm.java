package com.practice.algo.ds;

import java.util.*;

/**
 *
 *  add - 1, boook - 1, abc - 0
 *  2 - 1
 *  3 - 1
 *  4 - 2
 *  5 -
 *  oeoeo -> 2
 *  6 ->
 *  oooooo - > 3
 *
 */

public class SchedulingAlgorithm {
    public List<Integer> schedule(int processors, int[] arrivalTime, int[] burstTime) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i < processors; i++) {
            priorityQueue.add(i);
        }

        Map<Integer, Integer> arrivalBurstMap = new HashMap<>();
        for (int i = 0; i < arrivalTime.length; i++) {
            arrivalBurstMap.put(arrivalTime[i], burstTime[i]);
        }

        Arrays.sort(arrivalTime);
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> freeTimeToProcessor = new TreeMap<>();
        for (int i = 0; i < arrivalTime.length; i++) {
            if (!freeTimeToProcessor.isEmpty()) {
                int firstKey = freeTimeToProcessor.firstKey();
                if (arrivalTime[i] >= freeTimeToProcessor.firstKey()) {
                    priorityQueue.add(freeTimeToProcessor.get(firstKey));
                    freeTimeToProcessor.remove(firstKey);
                }
            }
            if (!priorityQueue.isEmpty()) {
                int processor = priorityQueue.remove();
                ans.add(processor);
                freeTimeToProcessor.put(arrivalTime[i] + burstTime[i], processor);
            } else {
                ans.add(-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SchedulingAlgorithm().schedule(3, new int[]{2, 4, 1, 8, 9}, new int[]{7, 9, 2, 4, 5}));
    }
}
