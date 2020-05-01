package com.udemy.java.test.biConsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestMainBiConsumer {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Vinoth");
        list.add("Selva");


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

        BiConsumer<String,Integer> biConsumer = (s,i) -> {

            System.out.println("My Name is "+ s);
            System.out.println("My age is " + i);
        };

        //biConsumer.accept("Udemy",55);

        Map<String,Consumer<String>> map = new HashMap<>();

        map.put("db",dbConsumer);
        map.put("log",loginConsumer);
        map.put("dblogCherry",dbLoginCherryConsumer);

        map.forEach((k,v)-> {
            System.out.println("Key is :: " + k);
        });

        //list.forEach(map.get(System.getProperty("consumer-type")));
    }
}
