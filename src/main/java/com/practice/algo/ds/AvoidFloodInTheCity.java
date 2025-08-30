package com.practice.algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        // Map to track the last day when a lake was filled
        Map<Integer, Integer> fullLakes = new HashMap<>();
        // TreeSet to maintain the indices of dry days
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                // Dry day, initialize with 1 as placeholder
                dryDays.add(i);
                result[i] = 1;
            } else {
                result[i] = -1; // Raining day, must be -1
                if (fullLakes.containsKey(lake)) {
                    // Lake is already full, find a dry day to empty it
                    int lastFullDay = fullLakes.get(lake);
                    Integer dryDay = dryDays.higher(lastFullDay);
                    if (dryDay == null) {
                        return new int[0]; // No suitable dry day => flood
                    }
                    result[dryDay] = lake; // Dry this lake on dryDay
                    dryDays.remove(dryDay); // Remove used dry day
                }
                // Update the last full day for this lake
                fullLakes.put(lake, i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AvoidFloodInTheCity().avoidFlood(new int[]{69, 0, 0, 0, 69})));
    }
}
