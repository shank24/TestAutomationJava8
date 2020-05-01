package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.List;

public class TestSorted {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(8);
        list.add(9);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(1);
        list.add(2);


        // With Stream Implementation
        list
                // All values at Stream Level
                .stream()
                // Filter - allow even numbers
                .filter(i -> {
                    System.out.println("Filter-Received :: " +i);
                    return i%2==0;
                }).sorted()
                // Limit to 3 (Max)
                .limit(3)
                //Finds Square
                .map(i-> {
                    System.out.println("Map - Received :: " + i);
                    return i*i;
                })
                // Printing the result
                .forEach(System.out::println);
    }
}
