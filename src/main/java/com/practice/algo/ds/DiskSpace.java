package com.practice.algo.ds;

import java.util.HashSet;
import java.util.Set;

public class DiskSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        int windowStart = 0;
        int windowEnd = 0;
        for (int i = 1; i <= blockSize; i++) {
            if (windowStart != 0
                    && windowEnd != 0
                    && (windowEnd - windowStart) == fileSize - 1) {
                return true;
            }
            if (!occupiedSectors.contains(i) && windowStart == 0) {
                windowStart = i;
                windowEnd = i;
            } else if (!occupiedSectors.contains(i) && windowStart != 0) {
                windowEnd++;
            } else if (occupiedSectors.contains(i)
                    && windowStart != 0
                    && windowEnd != 0) {
                windowStart = 0;
                windowEnd = 0;
            }
        }
        return windowStart != 0
                && windowEnd != 0
                && (windowEnd - windowStart) == fileSize - 1;
    }

    public static void main(String[] s) {
        System.out.println(isWritable(1, 1, new HashSet<>()));
    }
}
