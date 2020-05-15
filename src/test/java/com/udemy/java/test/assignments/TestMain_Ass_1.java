package com.udemy.java.test.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestMain_Ass_1 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/home/shanky/Personal/JAVA/firstname.txt");
        List<String> list = Files.readAllLines(path);

        // Print the count of Names, starting with B

        long countB = list.
                stream()
                .filter(s -> s.startsWith("B"))
                .count();

        System.out.println(countB);

        // Create a list of Name, which starts with C and contains 'S'

        long countChasS = list.
                stream().filter(s -> s.startsWith("C")).
                filter(s -> s.toLowerCase().contains("s")).
                count();

        System.out.println(countChasS);


        // Print the total number of char all the names start with 'M'

        list.stream().filter(s-> s.startsWith("M")).





    }
}
