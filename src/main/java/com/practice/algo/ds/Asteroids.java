package com.practice.algo.ds;

import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
 * right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
 * both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 * <p>
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 * <p>
 * Tags: Stack
 * Similar Problems: (E) Can Place Flowers
 *
 * [5, 10, -5]
 *
 * if > 0
 * 5,10
 * if < 0
 * peek and compare
 * 10 - 5 > 0 do nothing
 * 10 - 10 = 0 pop
 * 10 - 12 < 0 pop & repeat till stack is empty
 * 5, 10
 */

public class Asteroids {
    
    public int[] asteroids(int[] input) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                stack.push(input[i]);
            } else {
                while(!stack.isEmpty()) {
                    if (stack.peek() + input[i] < 0) {
                        stack.pop();
                    } else if (stack.peek() + input[i] > 0) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        
        int[] result = new int[stack.size()];
        if (stack.isEmpty()) {
            result = new int[] {};
        }
        int j = stack.size() - 1;
        while(!stack.isEmpty()) {
            result[j] = stack.pop();
            j--;
        }
        return result;
    }
    
    public static void main(String[] s) {
        int[] input = {10, 2, -5};
        int[] result = new Asteroids().asteroids(input);
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j] + " ");
        }
        
    }
}
