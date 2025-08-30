package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public int[][] merge(int[][] input) {
        // sort the interval by start time.
        Arrays.sort(input, (o1, o2) -> o1[0] - o2[0]);

        // will be used to store the new intervals, merged/non-merged
        List<int[]> list = new ArrayList<>();
        int i = -1;
        for (int[] interval : input) {
            if (i == -1 || interval[0] > list.get(i)[1]) { // no merging
                i++;
                int[] io = new int[2];
                io[0] = interval[0];
                io[1] = interval[1];
                list.add(io);
            } else { // merging
                list.get(i)[0] = Math.min(list.get(i)[0], interval[0]);
                list.get(i)[1] = Math.max(list.get(i)[1], interval[1]);
            }
        }
        // converting the list to 2-d array.
        int[][] output = new int[list.size()][2];

        int x = 0;
        for (int[] interval : list) {
            output[x][0] = interval[0];
            output[x][1] = interval[1];
            x++;
        }
        return output;
    }

    public static void main(String[] s) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] output = mergeIntervals.merge(new int[][] {{1,3},{2,6},{8,10},{15,18},{17,20}});
        System.out.println(output);
    }
}
