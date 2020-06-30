package com.practice.algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Smoothie {

    private static Map<String, Set<String>> menu;

    static {
        menu = new HashMap<>();
        Set<String> classicMenu =
                new HashSet<>(Arrays.asList("strawberry,banana,pineapple,mango,peach,honey".split(",")));
        Set<String> freezieMenu =
                new HashSet<>(Arrays.asList("blackberry,blueberry,black currant,grape juice,frozen yogurt".split(",")));
        Set<String> greenieMenu =
                new HashSet<>(Arrays.asList("green apple,lime,avocado,spinach,ice,apple juice".split(",")));
        Set<String> justDessertsMenu =
                new HashSet<>(Arrays.asList("banana,ice cream,chocolate,peanut,cherry".split(",")));
        menu.put("Classic", classicMenu);
        menu.put("Freezie", freezieMenu);
        menu.put("Greenie", greenieMenu);
        menu.put("Just Desserts", justDessertsMenu);
    }

    public static String ingredients(String order) {
        if (order == null || order.length() == 0) {
            throw new IllegalArgumentException();
        }
        String[] parsedOrder = order.split(",");

        if (parsedOrder.length == 0 ||
                !menu.containsKey(parsedOrder[0]) ||
                Arrays.stream(parsedOrder)
                        .filter(element -> !element.startsWith("-"))
                        .skip(1).count() > 0) {
            throw new IllegalArgumentException();
        }

        return menu.get(parsedOrder[0]).stream()
                .filter(element -> !Arrays.asList(parsedOrder).contains("-" + element))
                .sorted()
                .collect(Collectors.joining(","));
    }

    public static void main(String[] s) {
        System.out.println(ingredients("Classic,-strawberry,-banana,-pineapple,-mango,-peach,-honey"));
    }
}
