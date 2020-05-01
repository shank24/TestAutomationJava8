package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamLoop {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // End is non-Inclusive (1 - 9)
        IntStream.range(1,10)
                .forEach(i-> System.out.println("Hello World " + i));

        // End is Inclusive (1 - 10)
        IntStream.rangeClosed(1,10)
                .forEach(i-> System.out.println("Hello World " + i));
    }
}
