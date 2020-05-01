package com.udemy.java.test.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectorGrouping {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Apple");
        list.add("Mango");
        list.add("Airplane");
        list.add("Rupin");
        list.add("Kedarkantha");
        list.add("Stok Kangri");
        list.add("Roopkund");
        list.add("Matterhorn");
        list.add("Hampta Pass");

       // Grouping By length of the Characters in the word
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(collect);
        System.out.println(collect.get(8));

        Map<Character, List<String>> collect1 = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

        System.out.println(collect1);

    }

}
