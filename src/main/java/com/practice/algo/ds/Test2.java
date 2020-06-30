package com.practice.algo.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Test2 {

    public int solution(int[] A) {
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int minimumLength = 10000000;

        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            if (map.get(A[i]) <= 1) {
                count++;
            }

            if (count == set.size()) {
                while (map.get(A[start]) > 1) {
                    map.put(A[start], map.get(A[start]) - 1);
                    start++;
                }

                if (i - start + 1 < minimumLength) {
                    minimumLength = i - start + 1;
                }
            }
        }
        return minimumLength;
    }

    public static void main(String[] str) {
        System.out.println(new Test2()
                .solution(new int[]{2, 1, 1, 3, 2, 1, 1, 3}));

        System.out.println(new Test2()
                .solution(new int[]{7, 5, 2, 7, 2, 7, 4, 7}));
        System.out.println(UUID.randomUUID().toString());
    }
}
