package com.practice.algo.ds;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPermutation {
    
    static List<String> output = new ArrayList<>();
    
    public static List<String> perm(String input1, int originalLen) {
        if (input1.length() == 1) {
            return Collections.singletonList(input1);
        }
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < input1.length(); i++) {
            char c = input1.charAt(i);
            List<String> out = perm(input1.substring(0, i) + input1.substring(i+1), originalLen);
            String finalOut = Character.toString(c);
            for(String s : out) {
                finalOut = finalOut + s;
                if (finalOut.length() == originalLen) {
                    output.add(finalOut);
                } else {
                    temp.add(finalOut);
                }
                finalOut = Character.toString(c);
            }
        }
        return temp;
    }
    
    public static void main(String[] s) {
        perm("abcd", 4);
        System.out.println(output);
        System.out.println(output.size());
    }
}
