package com.practice.algo.ds;

import java.util.Arrays;

public class TestSplit {

    public static void testSplit(String input) {
        String[] output = input.split(",");
        Arrays.stream(output).forEach(System.out::println);
    }

    public static void main(String[] s) {
        testSplit("test");
    }
}
