package com.practice.algo.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FootballPlayerSelection {

    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        Map<String, List<String>> output = new TreeMap<>();
        Map<String, List<Player>> selectionGroupToPlayerMap = new HashMap<>();
        for (List<String> input : applications) {
            String name = input.get(0);
            float height = Float.parseFloat(input.get(1));
            float bmi = Float.parseFloat(input.get(2));
            int scores = Integer.parseInt(input.get(3));
            int defends = Integer.parseInt(input.get(4));

            Player player = new Player(name, height, bmi, scores, defends);

            if (player.height >= 5.8 && player.bmi <= 23) {
                if (player.defends >= 30 && player.scores >= 50) {
                    player.belongsToSelectionGroup = "SD";
                    selectionGroupToPlayerMap.computeIfAbsent("SD", z -> new ArrayList<>()).add(player);
                } else if (player.defends >= 30) {
                    player.belongsToSelectionGroup = "D";
                    selectionGroupToPlayerMap.computeIfAbsent("D", z -> new ArrayList<>()).add(player);
                } else if (player.scores >= 50) {
                    player.belongsToSelectionGroup = "S";
                    selectionGroupToPlayerMap.computeIfAbsent("S", z -> new ArrayList<>()).add(player);
                } else {
                    player.belongsToSelectionGroup = "NA";
                    output.put(player.name, singletonList(player.name + " REJECT " + "NA"));
                }
            }
        }
        List<Player> strikers = selectionGroupToPlayerMap.getOrDefault("S", new ArrayList<>());
        strikers.sort(new PlayerScoreComparator().reversed());

        List<Player> defenders = selectionGroupToPlayerMap.getOrDefault("D", new ArrayList<>());
        defenders.sort(new PlayerDefendComparator().reversed());

        List<Player> strikerDefenders = selectionGroupToPlayerMap.getOrDefault("SD", new ArrayList<>());

        int countOfStrikers = strikers.size();
        int countOfDefenders = defenders.size();
        if (countOfStrikers > countOfDefenders) {
            int diff = countOfStrikers - countOfDefenders;
            if (diff <= strikerDefenders.size()) {
                strikerDefenders.sort(new PlayerDefendComparator().reversed());
                strikerDefenders.stream().limit(diff).forEach(defender -> {
                    output.put(defender.name, singletonList(defender.name + " SELECT " + "DEFENDER"));
                });
                strikers.forEach(striker -> output.put(striker.name, singletonList(striker.name + " SELECT " + "STRIKER")));
            } else {
                for (int i = 0; i < countOfStrikers; i++) {
                    Player p = strikers.get(i);
                    if (i < countOfDefenders) {
                        output.put(p.name, singletonList(p.name + " SELECT " + "STRIKER"));
                    } else {
                        output.put(p.name, singletonList(p.name + " REJECT " + "NA"));
                    }
                }
            }
            defenders.forEach(defender -> output.put(defender.name, singletonList(defender.name + " SELECT " + "DEFENDER")));
        } else if (countOfStrikers < countOfDefenders) {
            int diff = countOfDefenders - countOfStrikers;
            if (diff <= strikerDefenders.size()) {
                strikerDefenders.sort(new PlayerDefendComparator().reversed());
                strikerDefenders.stream().limit(diff).forEach(striker -> {
                    output.put(striker.name, singletonList(striker.name + " SELECT " + "STRIKER"));
                });
                defenders.forEach(defender -> output.put(defender.name, singletonList(defender.name + " SELECT " + "DEFENDER")));
            } else {
                for (int i = 0; i < countOfDefenders; i++) {
                    Player p = defenders.get(i);
                    if (i < countOfStrikers) {
                        output.put(p.name, singletonList(p.name + " SELECT " + "DEFENDER"));
                    } else {
                        output.put(p.name, singletonList(p.name + " REJECT " + "NA"));
                    }
                }
            }
            strikers.forEach(striker -> output.put(striker.name, singletonList(striker.name + " SELECT " + "STRIKER")));
        } else {
            strikers.forEach(striker -> output.put(striker.name, singletonList(striker.name + " SELECT " + "STRIKER")));
            defenders.forEach(defender -> output.put(defender.name, singletonList(defender.name + " SELECT " + "DEFENDER")));
        }
        return new ArrayList<>(output.values());
    }

    private static class Player {
        private String name;
        private float height;
        private float bmi;
        private int scores;
        private int defends;
        private String belongsToSelectionGroup;

        public Player(String name, float height, float bmi, int scores, int defends) {
            this.name = name;
            this.height = height;
            this.bmi = bmi;
            this.scores = scores;
            this.defends = defends;
        }
    }

    private static class PlayerScoreComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            return Integer.compare(o1.scores, o2.scores);
        }
    }

    private static class PlayerDefendComparator implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            return Integer.compare(o1.defends, o2.defends);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int applicationsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int applicationsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> applications = new ArrayList<>();

        IntStream.range(0, applicationsRows).forEach(i -> {
            try {
                applications.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<String>> result = FootballPlayerSelection.getSelectionStatus(applications);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {

                    System.out.println(e);
                    //bufferedWriter.write(e);

                });

        bufferedReader.close();
        // bufferedWriter.close();
    }
}
