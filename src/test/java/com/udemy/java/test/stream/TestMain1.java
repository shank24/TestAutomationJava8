package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.List;

public class TestMain1 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(20);
        list.add(31);
        list.add(40);
        list.add(51);
        list.add(60);
        list.add(71);
        list.add(80);
        list.add(91);
        list.add(100);

        //Check for even numbers
        // ensure that number>5
        // find the square + 2 in that number
        // print it to the console

        // With Stream Implementation
                list
                .stream()
                .filter(i -> i%2==0 && i>5)
                .map(i-> i*i)
                .map(i -> i+2)
                .forEach(System.out::println);
    }
}
