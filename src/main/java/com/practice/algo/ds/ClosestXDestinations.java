package com.practice.algo.ds;

import java.util.*;
import java.util.stream.Collectors;

public class ClosestXDestinations {

    public static double computeDistance(int x, int y) {
        return Math.sqrt((x * x + y * y));
    }

    public static List<List<Integer>> closestXdestinations(
            int numDestinations,
            List<List<Integer>> allLocations,
            int numDeliveries
    ) {

        Map<Double, List<List<Integer>>> map = new TreeMap<>();

        for (int i = 0; i < allLocations.size(); i++) {
            List<Integer> coordinates = allLocations.get(i);
            double distance
                    = computeDistance(coordinates.get(0),
                    coordinates.get(1));
            map.computeIfAbsent(distance, z -> new ArrayList<>()).add(coordinates);
        }

        return map.values().parallelStream().flatMap(List::stream).limit(numDeliveries).collect(Collectors.toList());
    }

    public static void printList(List<List<Integer>> locations) {
        locations.stream()
                .map(location -> location.get(0) + " " + location.get(1))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<List<Integer>> allLocations =
                new ArrayList<>();
        allLocations.add(Arrays.asList(1, -3));
        allLocations.add(Arrays.asList(1, 2));
        allLocations.add(Arrays.asList(1, -2));
        allLocations.add(Arrays.asList(3, 4));
        printList(closestXdestinations(4, allLocations, 2));
    }
}