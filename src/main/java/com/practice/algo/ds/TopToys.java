package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopToys {

    public static void main(String[] s) {
        List<String> list = new ArrayList<>();
        list.add("elmo");
        list.add("elsa");
        list.add("legos");
        list.add("drone");
        list.add("tablet");
        list.add("warcraft");

        List<String> list1 = new ArrayList<>();
        list1.add("Elmo si the Elmo");
        list1.add("New Elmo dolls");
        list1.add("Expect Elsa dolls");
        list1.add("Elsa and Elmo and drone is");
        list1.add("them drone");
        list1.add("Warcraft an drone is slowly rising");

        System.out.println(popularNToys(6, 2, list, 6, list1));
    }

    private static ArrayList<String> popularNToys(int numToys, int topToys,
                                                  List<String> toys,
                                                  int numQuotes,
                                                  List<String> quotes) {
        ArrayList<String> output = new ArrayList<>();
        Map<Integer, TreeSet<String>> map = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> quotesMap = new HashMap<>();
        // add all words in quotes to map
        for (String input : quotes) {
            for (String s : new HashSet<>(Arrays.asList(input.toLowerCase().split(" ")))) {
                quotesMap.put(s, quotesMap.getOrDefault(s, 0) + 1);
            }
        }
        // check and store toys occurrence in all quotes in sorted order of occurrence and
        // for same occurrence store in alphabetical order.
        for (String toy : toys) {
            toy = toy.toLowerCase();
            map.computeIfAbsent(quotesMap.getOrDefault(toy, 0), z -> new TreeSet<>()).add(toy);
        }
        // find top k toys
        for (Map.Entry<Integer, TreeSet<String>> entry : map.entrySet()) {
            if (topToys > 0) {
                for (String s : entry.getValue()) {
                    if (topToys <= 0) {
                        break;
                    }
                    output.add(s);
                    topToys--;
                }
            } else {
                break;
            }
        }
        return output;
    }
}
