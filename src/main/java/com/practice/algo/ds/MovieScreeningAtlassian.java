package com.practice.algo.ds;

import java.util.*;

/**
 *
 * Manager of the cinema hall,
 * 1. Have to screen the movies
 * 2. If the new movie can be added to the existng schedule w/o removing existing movie
 * 3. cinema opens at 10 AM and closes at 11 PM - single day schedule
 * 4. movies start & end time is the number of mins from midnight.
 *
 * boolean canSchedule(Movie movie, MovieSchedule schedule);
 *
 * takes the movie (duration of the movie) as input and tell if it can be scheudled.
 *
 * -> 600 ->
 * -> 1380
 * {
 *"movies": [
 *     {
 *       "title": "Lord Of The Rings",
 *       "durationInMinutes":  120
 *     },
 *     {
 *       "title": "Back To The Future",
 *       "durationInMinutes":  90
 *     }
 *   ],
 *   "screenings": [
 *     {
 *       "title": "Lord Of The Rings",
 *       "startTime": 660
 *     },
 *     {
 *       "title": "Lord Of The Rings",
 *       "startTime": 840
 *     },
 *     {
 *       "title": "Back To The Future",
 *       "startTime": 1020
 *     },
 *     {
 *       "title": "Lord Of The Rings",
 *       "startTime": 1200
 *     }
 *   ]
 * }
 */
public class MovieScreeningAtlassian {

    final int defaultStartTimeInMinutes = 600;
    final int defaultEndTimeInMinutes = 1380;

    public MovieScreeningAtlassian() {
    }


    public boolean canSchedule(Movie movie, MovieSchedule schedule) {// "3 idiots", 180
        // sort the screening list
        List<Screening> screenings = new ArrayList<>(schedule.screenings);
        int previousEndtime = defaultStartTimeInMinutes;
        for(Screening screening: screenings) {
            int availableDuration;
            availableDuration = screening.startTimeInMinutes - previousEndtime;
            previousEndtime = screening.endTimeInMinutes;
            if(availableDuration >= movie.duration) {
                return true;
            }
        }
        int availableDuration = defaultEndTimeInMinutes - previousEndtime ;
        return availableDuration >= movie.duration;
    }


    public static class Movie {
        String title;
        int duration;

        public Movie(String title, int duration) {
            this.title = title;
            this.duration = duration;
        }
    }

    public static class Screening implements Comparable<Screening>{
        String title;
        int startTimeInMinutes;
        int endTimeInMinutes;

        public Screening(String title, int startTimeInMinutes, int endTimeInMinutes) {
            this.title = title;
            this.startTimeInMinutes = startTimeInMinutes;
            this.endTimeInMinutes = endTimeInMinutes;
        }

        public Screening(String title, int startTimeInMinutes) {
            this.title = title;
            this.startTimeInMinutes = startTimeInMinutes;
        }

        @Override
        public int compareTo(Screening o) {
            return this.startTimeInMinutes - o.startTimeInMinutes;
        }
    }

    public static class MovieSchedule {
        SortedSet<Screening> screenings;
        Map<String, Movie> movieMap;

        public MovieSchedule() {
            this.movieMap = new HashMap<>();
            this.screenings = new TreeSet<>();
        }

        public void addMovie(Movie movie, Screening screening) {
            movieMap.put(movie.title, movie);
            Screening screening1 = new Screening(screening.title, screening.startTimeInMinutes, screening.startTimeInMinutes + movie.duration);
            screenings.add(screening1);
        }
    }

    public static void main(String[] args) {
        MovieScreeningAtlassian movieScreeningAtlassian = new MovieScreeningAtlassian();
        MovieSchedule movieSchedule = new MovieSchedule();
        movieSchedule.addMovie(new Movie("Lord Of The Rings", 120), new Screening("Lord Of The Rings", 660));

        movieSchedule.addMovie(new Movie("Lord Of The Rings", 120), new Screening("Lord Of The Rings", 840));

        movieSchedule.addMovie(new Movie("Back To The Future", 120), new Screening("Back To The Future", 660));
        movieSchedule.addMovie(new Movie("Lord Of The Rings", 120), new Screening("Lord Of The Rings", 1200));

        boolean canSchedule = movieScreeningAtlassian.canSchedule(new Movie("3 idiots", 1380), movieSchedule);

        boolean canSchedule1 = movieScreeningAtlassian.canSchedule(new Movie("ABC", 380), movieSchedule);

        System.out.println(canSchedule);

    }
}
