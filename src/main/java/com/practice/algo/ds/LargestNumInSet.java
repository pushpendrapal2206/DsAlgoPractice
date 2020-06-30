package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

public class LargestNumInSet {

    public static void main(String[] s) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(7);
        list.add(9);
        System.out.println(largestNum(list));
    }

    public static int largestNum(List<Integer> list) {
        int min = list.get(0);
        int max = list.get(list.size() - 1);

        for (int i = max + 1; i <= max + min; i++) {
            int j = list.size() - 1;
            int temp = i;
            while (j >= 0) {
                temp = temp % list.get(j);
                j--;
            }
            if (temp != 0) {
                return i;
            }
        }
        return -1;
    }
}
