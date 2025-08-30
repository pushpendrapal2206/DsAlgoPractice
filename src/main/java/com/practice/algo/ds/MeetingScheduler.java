package com.practice.algo.ds;

import java.util.List;

public class MeetingScheduler {
    public static Interval earliestAppropriateDuration(List<Interval> slots1, List<Interval> slots2, int duration) {
        slots1.sort((o1, o2) -> o2.getStart() - o1.getStart());
        slots2.sort((o1, o2) -> o2.getStart() - o1.getStart());
        int i = 0;
        int j = 0;
        while (i < slots1.size() && j < slots2.size()) {
            int start = Math.max(slots1.get(i).getStart(), slots2.get(i).getStart());
            int end = Math.min(slots1.get(i).getEnd(), slots2.get(i).getEnd());
            if (end - start >= duration) {
                return new Interval(start, start + duration);
            } else {
                if (slots1.get(i).getEnd() < slots2.get(i).getEnd()) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return new Interval(-1, -1);
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
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

    }
}
