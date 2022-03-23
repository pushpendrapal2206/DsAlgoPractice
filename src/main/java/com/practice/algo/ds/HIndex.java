package com.practice.algo.ds;

import java.util.Arrays;

public class HIndex {
    
    public static void main(String[] s) {
        new HIndex().hIndex(new int[] {3,0,6,1,5});
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1;
        for(int i = citations.length; i>0 ; i++) {
            if(citations[i] >= h) {
                h++;
            } else {
                h = i;
                break;
            }
        }
        return h;
    }
}
