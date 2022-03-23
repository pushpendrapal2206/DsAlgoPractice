package com.practice.algo.ds;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TrainDelay {
    
    public static void main(String[] s) {
        
        String [][] dates = new String[][] {
                {"Mar 14 2022 09:00:00 UTC", "Mar 14 2022 09:15:00 UTC"},
                {"Mar 14 2022 09:05:00 UTC", "Mar 14 2022 09:30:00 UTC"},
                {"Mar 14 2022 09:15:00 UTC", "Mar 14 2022 09:20:00 UTC"},
                {"Mar 14 2022 09:16:00 UTC", "Mar 14 2022 09:18:00 UTC"},
                {"Mar 14 2022 09:17:00 UTC", "Mar 14 2022 09:19:00 UTC"},
                {"Mar 14 2022 09:26:00 UTC", "Mar 14 2022 12:00:00 UTC"},
                {"Mar 14 2022 09:30:00 UTC", "Mar 14 2022 09:45:00 UTC"},
        };
        
        List<Train> trains = new ArrayList<>();
        for(String[] date : dates) {
            Long startTime = ZonedDateTime.parse(
                    date[0] ,
                    DateTimeFormatter.ofPattern ( "MMM d uuuu HH:mm:ss z" )
            ).toInstant().toEpochMilli();
            Long endTime = ZonedDateTime.parse(
                    date[1] ,
                    DateTimeFormatter.ofPattern ( "MMM d uuuu HH:mm:ss z" )
            ).toInstant().toEpochMilli();
            
            Train train = new Train(1, startTime, endTime);
            trains.add(train);
        }
        System.out.println(new TrainDelay().findDelay(trains, 2));
    }
    
    
    public static class Train {
        private int trainId;
        private final Long arrivalTime;
        private final Long departureTime;
        
        public Train(int trainId, Long arrivalTime, Long departureTime) {
            this.trainId = trainId;
            this.arrivalTime = arrivalTime;
            this.departureTime = departureTime;
        }
    }
    
    public int findDelay(List<Train> trains, int num_of_platfroms) { // time complexity = O(nlogm), space complexity = O(m);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        int tDelay = 0;
        for (Train t : trains) {   // n times
            if (num_of_platfroms > 0) {
                priorityQueue.add(t.departureTime);  // logm times
                num_of_platfroms--;
            } else {
                if(!priorityQueue.isEmpty() && priorityQueue.peek() >= t.arrivalTime) {
                    int delay = (int) (priorityQueue.poll() - t.arrivalTime);
                    tDelay = tDelay + delay;
                    priorityQueue.add(t.departureTime + delay); // logm times
                }
            }
        }
        return (tDelay/1000)/60;
    }
}
