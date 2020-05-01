package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TestSumOfNumbers {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Reduce helps you to accumulate all into 1 object
        Optional<Integer> reduce = list.stream()
                .reduce((a, b) -> {

                    System.out.println(a + " :: " + b);
                    return a+b;
                });

        System.out.println(reduce.get());


    }
}
