package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxFreqStack {
    
    static Map<Integer, Integer> f = new HashMap<>();
    static Map<Integer, Stack<Integer>> fs = new HashMap<>();
    
    static int mf = 0;
    
    public static void push(int input) {
        f.put(input, f.getOrDefault(input, 0) + 1 );
        int freq = f.get(input);
        mf = Math.max(mf, freq);
        Stack<Integer> stack = fs.getOrDefault(freq, new Stack<>());
        stack.push(input);
        fs.put(freq, stack);
    }
    
    
    
    public static int pop() {
        int top = fs.get(mf).pop();
        f.put(top, f.get(top) - 1 );
        if(fs.get(mf).isEmpty()) {
            mf--;
        }
        return top;
    }
    
    public static void main(String[] s) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(2);
        push(6);
        push(7);
        push(4);
        push(8);
        
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }
}
