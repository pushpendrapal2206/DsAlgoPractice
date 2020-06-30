package com.practice.algo.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class MaximizeMemoryUsage {
    public static void main(String[] s) {
        List<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(8);
        List<Integer> input2 = new ArrayList<>();
        input2.add(2);
        input2.add(7);
        List<Integer> input3 = new ArrayList<>();
        input3.add(3);
        input3.add(14);
        List<Integer> input4 = new ArrayList<>();
        input4.add(1);
        input4.add(5);
        List<Integer> input5 = new ArrayList<>();
        input5.add(2);
        input5.add(10);
        List<Integer> input6 = new ArrayList<>();
        input6.add(3);
        input6.add(14);
        List<List<Integer>> fback = new ArrayList<>();
        fback.add(input1);
        fback.add(input2);
        fback.add(input3);
        List<List<Integer>> bback = new ArrayList<>();
        bback.add(input4);
        bback.add(input5);
        bback.add(input6);
        List<Integer> input7 = new ArrayList<>();
        input7.add(1);
        input7.add(1);
        List<Integer> input8 = new ArrayList<>();
        input8.add(2);
        input8.add(5);
        List<Integer> input9 = new ArrayList<>();
        input9.add(3);
        input9.add(7);
        List<Integer> input10 = new ArrayList<>();
        input10.add(4);
        input10.add(10);
        List<Integer> input11 = new ArrayList<>();
        input11.add(1);
        input11.add(2);
        List<Integer> input12 = new ArrayList<>();
        input12.add(2);
        input12.add(3);
        List<Integer> input13 = new ArrayList<>();
        input13.add(3);
        input13.add(4);
        List<Integer> input14 = new ArrayList<>();
        input14.add(4);
        input14.add(5);
        List<List<Integer>> fback1 = new ArrayList<>();
        fback1.add(input7);
        fback1.add(input8);
        fback1.add(input9);
        fback1.add(input10);
        List<List<Integer>> bback2 = new ArrayList<>();
        bback2.add(input11);
        bback2.add(input12);
        bback2.add(input13);
        bback2.add(input14);
//        for (List<Integer> list : optimalUtilization(20, fback, bback)) {
//            System.out.println(list.get(0) + " " + list.get(1));
//        }

        for (List<Integer> list : optimalUtilization(6, fback1, bback2)) {
            System.out.println(list.get(0) + " " + list.get(1));
        }

    }

    public static List<List<Integer>> optimalUtilization(int deviceCapacity,
                                                         List<List<Integer>> foregroundAppList,
                                                         List<List<Integer>> backgroundAppList) {
        //sort the input arrays
        List<List<Integer>> output = new ArrayList<>();
        List<List<Integer>> sortedForeground = foregroundAppList.stream()
                .sorted(Comparator.comparingInt(element -> element.get(1)))
                .collect(Collectors.toList());
        //sort the input arrays
        List<List<Integer>> sortedBackground = backgroundAppList.stream()
                .sorted(Comparator.comparingInt(element -> element.get(1)))
                .collect(Collectors.toList());
        // create max heap with as sum of 2 array element
        PriorityQueue<QueueTuple> queue = new PriorityQueue<>(new QueueTupleComparator());

        int size = sortedForeground.size() - 1;
        //add the last elements sum in max heap
        QueueTuple queueTuple = new QueueTuple(size,
                size,
                sortedForeground.get(size).get(1) +
                        sortedBackground.get(size).get(1));
        queue.add(queueTuple);

        Set<QueueTuple> queueTupleSet = new HashSet<>();
        queueTupleSet.add(queueTuple);
        //iterate until we find capacity consumed lesser and equal to deviceCapacity
        while (queue.peek().getSum() > deviceCapacity) {
            queueTuple = queue.poll();
            if (queueTuple.getI() >= 1) {
                QueueTuple queueTuple1 = new QueueTuple(queueTuple.getI() - 1, queueTuple.getJ(),
                        sortedForeground.get(queueTuple.getI() - 1).get(1) +
                                sortedBackground.get(queueTuple.getJ()).get(1));
                if (!queueTupleSet.contains(queueTuple1)) {
                    queue.add(queueTuple1);
                    queueTupleSet.add(queueTuple1);
                }

            }
            if (queueTuple.getJ() >= 1) {
                QueueTuple queueTuple1 = new QueueTuple(queueTuple.getI(), queueTuple.getJ() - 1,
                        sortedForeground.get(queueTuple.getI()).get(1) +
                                sortedBackground.get(queueTuple.getJ() - 1).get(1));
                if (!queueTupleSet.contains(queueTuple1)) {
                    queue.add(queueTuple1);
                    queueTupleSet.add(queueTuple1);
                }
            }
        }

        QueueTuple maxUtilize = queue.peek();
        output.add(createPairList(queue, sortedForeground, sortedBackground));

        // check if there are multiple pairs with same memory consumption
        while (queue.peek().getSum() == maxUtilize.getSum()) {
            output.add(createPairList(queue, sortedForeground, sortedBackground));
        }
        return output;
    }

    private static List<Integer> createPairList(
            PriorityQueue<QueueTuple> queue,
            List<List<Integer>> sortedForeground,
            List<List<Integer>> sortedBackground) {
        QueueTuple maxUtilize = queue.poll();
        List<Integer> pairList = new ArrayList<>();
        pairList.add(sortedForeground.get(maxUtilize.getI()).get(0));
        pairList.add(sortedBackground.get(maxUtilize.getJ()).get(0));
        return pairList;
    }

    static class QueueTuple {
        int i;
        int j;
        int sum;

        public QueueTuple(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QueueTuple that = (QueueTuple) o;
            return i == that.i &&
                    j == that.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    static class QueueTupleComparator implements Comparator<QueueTuple> {
        @Override
        public int compare(QueueTuple o1, QueueTuple o2) {
            return o2.getSum() - o1.getSum();
        }
    }
}
