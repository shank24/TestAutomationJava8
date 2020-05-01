package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.List;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        b.add(6);


        List<Integer> c = new ArrayList<>();
        c.add(7);
        c.add(8);
        c.add(9);

        List<List<Integer>> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        // Printing List of  List
        list.stream()
                .forEach(l -> System.out.println(l));

        // Making all list printing one-by-one with the use of Flat

        list.stream()
                .flatMap(l -> l.stream())
                .limit(5)
                .map(i-> i*i*i)
                .forEach(l -> System.out.println(l));

    }
}
