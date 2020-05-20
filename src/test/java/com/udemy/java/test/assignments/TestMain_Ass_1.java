package com.udemy.java.test.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain_Ass_1 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/home/shanky/Personal/JAVA/firstname.txt");
        List<String> list = Files.readAllLines(path);

        // Print the count of Names, starting with B

        long countB =       list
                            .stream()
                            .filter(s -> s.startsWith("B"))
                            .count();

        System.out.println(countB);

        // Create a list of Name, which starts with C and contains 'S'

        List<String> collect = list
                                .stream()
                                .filter(s -> s.startsWith("C"))
                                .filter(s -> s.toLowerCase()
                                .contains("s"))

                                .collect(Collectors.toList());


        System.out.println(collect.size());

        // Other way around
                long countCS =      list
                                    .stream()
                                    .filter(s -> s.startsWith("C"))
                                    .filter(s -> s.toLowerCase()
                                    .contains("s"))
                                    .count();

                System.out.println(countCS);

        // Print the total number of char all the names start with 'M'

        int sumOfChar = list
                        .stream()
                        .filter(s -> s.startsWith("M"))
                        .map(String::trim)
                        .map(String::length)
                        .mapToInt(a -> a)
                        .sum();


        System.out.println(sumOfChar);
    }
}
