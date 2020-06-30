package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public int solution(String[] T, String[] R) {
        Map<String, Boolean> map = new HashMap<>();
        String pattern = "^.*\\d$";
        int i = 0;
        for (String s : T) {
            if (s.matches(pattern)) {
                map.put(s, R[i].equals("OK"));
            } else {
                String prefix = s.substring(0, s.length() - 1);
                map.put(prefix, map.getOrDefault(prefix, true) && R[i].equals("OK"));
            }
            i++;
        }
        long passedCountGroups = map.values().stream().filter(v -> v).count();
        return (int) Math.floor(passedCountGroups * 100 / map.size());
    }

    public static void main(String[] str) {
        System.out.println(new Test()
                .solution(new String[]{"test1", "test3", "test2", "test4b", "test4a"}, new String[]{"WA", "OK", "OK", "RE", "OK"}));
    }
}
