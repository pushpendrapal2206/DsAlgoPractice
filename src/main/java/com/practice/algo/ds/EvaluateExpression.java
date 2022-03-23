package com.practice.algo.ds;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 227. Basic Calculator II
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer
 * division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7  -> 322*+
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * <p>
 * Tags: String
 * Similar Problems: (H) Basic Calculator, (H) Expression Add Operators
 */

public class EvaluateExpression {
    public static void main(String[] s) {
        EvaluateExpression eval = new EvaluateExpression();
        System.out.println(eval.evaluatePostfix(eval.toPostfix(" 3+5 / 2 ")));
    }
    
    public String toPostfix(String input) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && !map.containsKey(c)) {
                postfix.append(c);
            } else if (c != ' ' && stack.isEmpty()) {
                stack.push(c);
            } else if (c != ' ') {
                while (map.get(stack.peek()) > map.get(c)) {
                    char top = stack.pop();
                    postfix.append(top);
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    
    public int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (map.containsKey(c)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (c) {
                    case '+' : stack.push(op1 + op2); break;
                    case '-' : stack.push(op1 - op2); break;
                    case '*' : stack.push(op1 * op2); break;
                    case '/' : stack.push(op1 / op2); break;
                    default: break;
                }
                
            } else {
                stack.push(Character.getNumericValue(c));
            }
        }
        return stack.pop();
    }
    
}
