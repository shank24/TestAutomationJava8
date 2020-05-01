package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.List;

public class TestPeek {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);



        // With Stream Implementation
                list
                .stream().skip(4)
                .peek(i -> System.out.println("Filter Received :: " + i))
                .filter(i -> i%2==0)
                .peek(i -> System.out.println("Map Received :: " + i))
                .limit(3)
                .map(i-> i*i)
                // Printing the result
                .forEach(System.out::println);
    }
}
