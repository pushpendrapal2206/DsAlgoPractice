package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class ElementDifference {

    public static boolean solution(int[] A) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int value : A) {
            map.put(value, true);
        }

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i] + 1) || map.containsKey(A[i] - 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] s) {
        System.out.println(ElementDifference.solution(new int[]{11, 1, 8, 12, 14}));
        System.out.println(ElementDifference.solution(new int[]{4, 4, 4, 4, 4}));
        System.out.println(ElementDifference.solution(new int[]{4, 3}));
    }
}
