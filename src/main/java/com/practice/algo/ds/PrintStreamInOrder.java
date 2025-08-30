package com.practice.algo.ds;

/**
 * A problem given with stream of event objects, print it in the order of end time.
 *  [10,12], [9,10], [1,2], [1,4]
 *  Need to know the threshold for delay of unordered events, based on that we can use heap of the same size.
 *  e.g if unordered could be upto nearby 5 events then we can use the min heap of size 5
 *  aabba ->
 *  aaaba
 *  aaaaa
 *  acccct ->  3
 *  aaaaa
 *
 */
public class PrintStreamInOrder {
}
