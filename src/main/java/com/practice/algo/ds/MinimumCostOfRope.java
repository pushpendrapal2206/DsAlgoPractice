package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostOfRope {

    public static void main(String[] s) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCount = 0;
        while ((line = br.readLine()) != null && line.length() > 0) {
            if (testCount != 0 && testCount % 2 == 0) {
                System.out.println(BigInteger.valueOf((long) minimumCostOfRope(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray())));
            }
            testCount++;
        }
    }

    static double minimumCostOfRope(int[] input) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for (int element : input) {
            priorityQueue.add((double) element);
        }
        double cost = 0;
        while (priorityQueue.size() > 1) {
            double sum = priorityQueue.poll() + priorityQueue.poll();
            cost = cost + sum;
            priorityQueue.add(sum);
        }
        return cost;
    }
}
