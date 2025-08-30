package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * (0,8),(8,10) is not conflict at 8
 * <p>
 * <p>
 * Example1
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 * <p>
 * Example2
 * Input: intervals = [(2,7)]
 * Output: 1
 * Explanation:
 * Only need one meeting room
 * <p>
 * Solution: Visualize a timeline if the current time represents start of meeting, we need a room
 * if the current time represents the end of meeting then the room has become free.
 * <p>
 * 1. have an array for both start and end times.
 * 2. sort both and increase the number of rooms when start time is encountered else reduce the number of rooms.
 *
 * start -> 0   5 15 25 35
 *                         i
 * end ->   10 20 30 39 40
 *                    j
 * cmr = 2
 * mmr = 2
 */
public class MeetingRoomsII {

    public static int maxMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).getStart();
            end[i] = intervals.get(i).getEnd();
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int currMeetingRooms = 0;
        int maxMeetingRooms = Integer.MIN_VALUE;
        while (i < start.length && j < start.length) {
            if (start[i] < end[j]) {
                currMeetingRooms = currMeetingRooms + 1;
                i++;
            } else {
                currMeetingRooms = currMeetingRooms - 1;
                j++;
            }
            maxMeetingRooms = Math.max(maxMeetingRooms, currMeetingRooms);
        }
        return maxMeetingRooms;
    }

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Interval interval1 = new MeetingRoomsII.Interval(0, 30);
        Interval interval2 = new MeetingRoomsII.Interval(5, 10);
        Interval interval3 = new MeetingRoomsII.Interval(35, 39);
        Interval interval4 = new MeetingRoomsII.Interval(15, 20);
        Interval interval5 = new MeetingRoomsII.Interval(25, 40);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);

        int canAttend = maxMeetingRooms(intervals);
        System.out.println("Number of Meeting rooms needed: " + canAttend);
    }
}

