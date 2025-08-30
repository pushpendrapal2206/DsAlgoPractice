package com.practice.algo.ds;

import java.util.*;

public class AverageRatingForUsers {
    Map<String, User> userMap;

    public AverageRatingForUsers() {
        this.userMap = new HashMap<>();
    }

    public void addRating(String username, int rating) {
        User user = userMap.computeIfAbsent(username, x -> new User(username));
        // calculate average rating
        int cumulativeRatingSum = user.getCumulativeRatingSum() + rating;
        int countOfRating = user.getCountOfRating() + 1;
        int averageRating = cumulativeRatingSum / countOfRating;
        user.setCumulativeRatingSum(cumulativeRatingSum);
        user.setCountOfRating(countOfRating);
        user.setAverageRating(averageRating);
        userMap.put(username, user);
    }

    public void printRatings() {
        List<Map.Entry<String, User>> list = new ArrayList<>(userMap.entrySet());
        list.sort(Comparator.comparingInt(u -> u.getValue().getAverageRating()));

        for (Map.Entry<String, User> entry : list) {
            System.out.println("Average rating for " + entry.getKey() + " is " + entry.getValue().getAverageRating());
        }
    }

    public static class User {
        private String name;
        private int averageRating;
        private int countOfRating;
        private int cumulativeRatingSum;

        public User(String username) {
            this.name = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAverageRating() {
            return averageRating;
        }

        public void setAverageRating(int averageRating) {
            this.averageRating = averageRating;
        }

        public int getCountOfRating() {
            return countOfRating;
        }

        public void setCountOfRating(int countOfRating) {
            this.countOfRating = countOfRating;
        }

        public int getCumulativeRatingSum() {
            return cumulativeRatingSum;
        }

        public void setCumulativeRatingSum(int cumulativeRatingSum) {
            this.cumulativeRatingSum = cumulativeRatingSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

    public static void main(String[] args) {
        AverageRatingForUsers averageRatingForUsers = new AverageRatingForUsers();
        averageRatingForUsers.addRating("pushpendra", 5);
        averageRatingForUsers.addRating("pushpendra", 3);
        averageRatingForUsers.addRating("pushpendra", 4);
        averageRatingForUsers.addRating("rajesh", 4);
        averageRatingForUsers.addRating("rajesh", 2);

        averageRatingForUsers.printRatings();
    }
}
