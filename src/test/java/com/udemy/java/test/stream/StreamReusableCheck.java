package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamReusableCheck {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Apple");
        list.add("Mango");
        list.add("Airplane");
        list.add("Rupin");
        list.add("Kedarkantha");
        list.add("Stok Kangri");
        list.add("Roopkund");
        list.add("Matterhorn");
        list.add("Hampta Pass");

        Stream<String> stringStream = list.stream().filter(s -> s.length() > 3);

        stringStream.forEach(s-> System.out.println(s));

        // It will throw an exception at runtime (Illegal State Exception)
        stringStream.forEach(s-> System.out.println(s.toUpperCase()));


    }
}
