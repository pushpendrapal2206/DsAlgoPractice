package com.practice.algo.ds;

/**
 * Find the K-th greatest element for every subarray ranging from size K to N.
 * -> [2,3,1,5,4,9,8] -> 7 K = 3, 4, 5, 6, 7
 * -> [1,1,1,4,4 ]
 * We can use heap for each window of size k , k + 1, K + 2 ... N.
 * But the time complexity would be N2logK
 */
public class KthLargest {
}
