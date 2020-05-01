package com.udemy.java.test.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TestMain {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Vinoth");
        list.add("Selva");


        Consumer<String> str = (s) -> System.out.println(s);

        str.accept("Java");


        Consumer<String> dbConsumer = (s) -> {
            System.out.println("I am writing into DB :: "+ s);
        };


        Consumer<String> loginConsumer = (s) -> {
            System.out.println("I am writing into Log File  :: "+ s);
        };

        Consumer<String> cherryConsumer = (s) -> {
            System.out.println("I am writing into Cherry  :: "+ s);
        };

        Consumer<String> dbLoginCherryConsumer = dbConsumer.andThen(loginConsumer).andThen(cherryConsumer);

        Map<String,Consumer<String>> map = new HashMap<>();

        map.put("db",dbConsumer);
        map.put("log",loginConsumer);
        map.put("dblogCherry",dbLoginCherryConsumer);

        //list.forEach(dbLoginCherryConsumer);

        //list.forEach(map.get(System.getProperty("consumer-type")));
    }
}
