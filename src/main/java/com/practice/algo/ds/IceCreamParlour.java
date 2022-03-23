package com.practice.algo.ds;

import java.util.HashMap;
import java.util.Map;

public class IceCreamParlour {
    
    public static void main(String[] s) {
       int[] result = new IceCreamParlour().findFlavours(6, new int[] {1,3,4,5,6});
       for(int i : result) {
           System.out.println(i);
       }
    }

    public int[] findFlavours(int m, int[] prices) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = {-1, -1};
        for(int i = 0; i <  prices.length; i++) {
            int checkKey = prices[i];
            int putKey = m - prices[i];
            if(map.containsKey(checkKey)) {
                res[0] = map.get(checkKey) + 1;
                res[1] = i + 1;
            } else {
                map.put(putKey, i);
            }
        }
        return res;
    }
}
