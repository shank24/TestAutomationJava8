package com.udemy.java.test.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollectorJoinOperation {

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

        // Collectors joining into a Single Word
        String collect = list.stream().filter(s -> s.length() > 3).collect(Collectors.joining(" : "));

        System.out.println(list);
        System.out.println(collect);
    }

}
