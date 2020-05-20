package com.udemy.java.test.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain_Ass_2 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/home/shanky/Personal/JAVA/firstname.txt");
        List<String> list = Files.readAllLines(path);

        // Jo-Ann
        // Find the names containing, "-" in it, and replace it with
        // a space, collect them into a list.

        List<String> collect = list
                                .stream()
                                .filter(s -> s.contains("-"))
                                .map(s -> s.replaceAll("-", " "))
                                .collect(Collectors.toList());

        System.out.println(collect);

        //Find the name which has more no. of Char
        // Anna Bob -> Anna (4) char


        String s1 = list
                .stream()
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println(s1);



    }
}
