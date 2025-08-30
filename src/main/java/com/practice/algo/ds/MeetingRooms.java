package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description
 * Given an array of meeting time intervals consisting of start and end times [(s1,e1),(s2,e2),...] (si < ei), determine if a person could attend all meetings.
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 * Example2
 * Input: intervals = [(5,8),(9,15)]
 * Output: true
 * Explanation:
 * Two times will not conflict
 *
 * Solution :
 * 1. Sort the intervals by start time of the meeting.
 * 2. Compare the start of the current meeting with end time of the previous meeting, if overlaps then false.
 */
public class MeetingRooms {

    public static boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).getStart() < intervals.get(i - 1).getEnd()) {
                return false;
            }
        }
        return true;
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
        Interval interval1 = new MeetingRooms.Interval(0, 30);
        Interval interval2 = new MeetingRooms.Interval(5, 10);
        Interval interval3 = new MeetingRooms.Interval(35, 39);
        Interval interval4 = new MeetingRooms.Interval(15, 20);
        Interval interval5 = new MeetingRooms.Interval(25, 40);

        List<Interval> intervals = new ArrayList<>();
//        intervals.add(interval1);
        intervals.add(interval2);
//        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);

        boolean canAttend = canAttendMeetings(intervals);
        System.out.println("Can attend Meetings: " + canAttend);
    }
}

