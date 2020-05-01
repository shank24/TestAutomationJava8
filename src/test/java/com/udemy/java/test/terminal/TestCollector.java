package com.udemy.java.test.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestCollector {

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

        // Collectors.toList creates a new list, without modifying the previous list
        List<String> collect = list.stream().filter(s -> s.length() > 7)
                .collect(Collectors.toList());

        System.out.println("Original :: "+ list);
        System.out.println("New One :: " + collect);

        System.out.println(list.hashCode());
        System.out.println(collect.hashCode());

        //Collect Data into Set, without duplicates
        Set<String> collect1 = list.stream().filter(s -> s.length() > 3)
                .collect(Collectors.toSet());

        System.out.println(collect1);

    }

}
