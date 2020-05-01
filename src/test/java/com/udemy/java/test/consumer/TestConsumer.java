package com.udemy.java.test.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Nathan");
        list.add("James");

        Consumer<String> c1 = (s) -> System.out.println(s);

        list.forEach(c1);
        list.forEach(System.out::println);


    }
}


