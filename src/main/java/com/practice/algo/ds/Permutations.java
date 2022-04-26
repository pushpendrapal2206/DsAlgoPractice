package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations sol = new Permutations();
        System.out.println(sol.permutations(new int[]{1,2,3,4}));
    }
    
    public List<List<Integer>> permutations(int[] input) { //[1, 2, 3]
        List<List<Integer>> output = new ArrayList<>(); // [[]]
        permutations(input, new ArrayList<>(), output); //
        return output;
    }
    
    public void permutations(int[] input, List<Integer> asf, List<List<Integer>> output) { //[1, 2, 3]
        if (input.length == 0) {
            output.add(asf); // [[1,2,3]]
        }
        
        for (int i = 0; i < input.length; i++) { // 0
            List<Integer> newasf = new ArrayList<>(asf);
            newasf.add(input[i]);
            permutations(getSubarray(input, i), newasf, output); // [], [1, 2, 3], [[]]
        }
    }
    
    public int[] getSubarray(int[] input, int i) { // [1,2,3] , 0
        int[] a = new int[input.length - 1]; //[0 , 0]
        int k = 0;
        for (int j = 0; j < input.length; j++) { // 0 , 1, ,2
            if (j != i) {
                a[k] = input[j];
                k++;
            }
            
        }
        return a; // [2,3]
    }
}
