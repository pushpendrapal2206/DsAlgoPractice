package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Indicium {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int cases = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (cases > 0) {
                String output = "";
                String[] strArr = line.split(" ");
                int n = Integer.parseInt(strArr[0]);
                int k = Integer.parseInt(strArr[1]);

                if (k % n == 0) {
                    int temp = k / n;
                    for (int i = 1; i <= n; i++) {
                        if (temp == i) {
                            output = "POSSIBLE";
                        }
                    }
                } else {
                    output = "IMPOSSIBLE";
                }
                System.out.println("Case #" + cases + ": " + output);
            }
            cases++;
        }

    }
}
