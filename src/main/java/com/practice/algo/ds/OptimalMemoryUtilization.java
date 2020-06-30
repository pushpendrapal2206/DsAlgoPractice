package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class OptimalMemoryUtilization {
    public static List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> forgroundAppList,
            List<List<Integer>> backgroundAppList
    ) {

        int maxSofar = Integer.MIN_VALUE;

        SortedMap<Integer, List<List<Integer>>> resultMap = new TreeMap<>();


        for (List<Integer> flist : forgroundAppList) {

            for (List<Integer> blist : backgroundAppList) {

                int currMemoryUtilzation = flist.get(1) + blist.get(1);

                if (currMemoryUtilzation >= maxSofar && currMemoryUtilzation <= deviceCapacity) {
                    maxSofar = currMemoryUtilzation;
                    List<Integer> appIds = new ArrayList<>();
                    appIds.add(flist.get(0));
                    appIds.add(blist.get(0));
                    if (resultMap.containsKey(currMemoryUtilzation)) {
                        List<List<Integer>> temp = resultMap.get(currMemoryUtilzation);
                        temp.add(appIds);
                    } else {

                        List<List<Integer>> temp = new ArrayList<>();
                        temp.add(appIds);
                        resultMap.put(currMemoryUtilzation, temp);
                    }
                }

            }

        }


        return ((TreeMap<Integer, List<List<Integer>>>) resultMap).lastEntry().getValue();


    }

    public static void main(String[] args) {
        List<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(8);
        List<Integer> input2 = new ArrayList<>();
        input2.add(2);
        input2.add(7);
        List<Integer> input3 = new ArrayList<>();
        input3.add(3);
        input3.add(14);
        List<Integer> input4 = new ArrayList<>();
        input4.add(1);
        input4.add(5);
        List<Integer> input5 = new ArrayList<>();
        input5.add(2);
        input5.add(10);
        List<Integer> input6 = new ArrayList<>();
        input6.add(3);
        input6.add(14);
        List<List<Integer>> fback = new ArrayList<>();
        fback.add(input1);
        fback.add(input2);
        fback.add(input3);
        List<List<Integer>> bback = new ArrayList<>();
        bback.add(input4);
        bback.add(input5);
        bback.add(input6);
        System.out.println(optimalUtilization(24, fback, bback));
    }

}
