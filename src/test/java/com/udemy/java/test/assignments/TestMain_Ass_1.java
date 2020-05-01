package com.udemy.java.test.assignments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMain_Ass_1 {

    public static void main(String[] args) throws IOException {

        ///home/shanky/Personal/JAVA

        Path path = Paths.get("/home/shanky/Personal/JAVA/firstname.txt");
        Files.readAllLines(path);

    }
}
