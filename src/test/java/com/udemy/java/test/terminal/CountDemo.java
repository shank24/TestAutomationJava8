package com.udemy.java.test.terminal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CountDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("apple");
        list.add("ball");
        list.add("cat");
        list.add("dog");

        //Count Demo
        System.out.println(
                list.stream().filter(s -> s.length()>3).count()
        );

        // Find First
        System.out.println(
                list.stream()
                .filter(s -> s.length()>3)
                .findFirst()

        );

        // Optional Explanation
        Optional<String> first = list.stream()
                                .filter(s -> s.length() > 3)
                                .findFirst();

        if(first.isPresent()){
            System.out.println(first.get());
        }

        //Min in Natural Order
        System.out.println(
        list.stream().min(Comparator.naturalOrder())
                .get()
        );


        //Min in Reverse Order
        System.out.println(
        list.stream().min(Comparator.reverseOrder())
                .get());


        //Max in Natural Order
        System.out.println(
        list.stream().max(Comparator.naturalOrder())
                .get());


        //Max in Reverse Order
        System.out.println(
        list.stream().max(Comparator.reverseOrder())
                .get());

        //Any Match
        System.out.println(
                list.stream().filter(e -> e.length()>3).anyMatch(e-> e.contains("e"))
        );

        //None Match
        System.out.println(
                list.stream().filter(e -> e.length()>3).noneMatch(e-> e.contains("y"))
        );
    }



}
