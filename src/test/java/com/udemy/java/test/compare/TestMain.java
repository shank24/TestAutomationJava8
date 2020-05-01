package com.udemy.java.test.compare;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {

        StudentClass a = new StudentClass("Adam", 80, 150);
        StudentClass b = new StudentClass("Bob", 96, 123);
        StudentClass c = new StudentClass("Carl", 75, 135);

        //Getting the Minimum Score
        Optional<StudentClass> minScore = Stream.of(a, b, c).min(Comparator.comparing(s -> s.getScore()));



        if(minScore.isPresent()) {
            System.out.println("Minimum Scorer Student :: " +  minScore.get());
        }
        else{
            System.out.println("Nothing");
        }

        //Getting the Maximum Score
        Optional<StudentClass> maxScore = Stream.of(a, b, c).max(Comparator.comparing(s -> s.getScore()));


        if(maxScore.isPresent()) {
            System.out.println("High Scorer Student :: " + maxScore.get());
        }
        else{
            System.out.println("Nothing");
        }

        //Getting the Maximum Score
        Optional<StudentClass> tallestStudent = Stream.of(a, b, c).max(Comparator.comparing(s -> s.getHeight()));

        if(tallestStudent.isPresent()) {
            System.out.println("Tallest Student :: " + tallestStudent.get());
        }
        else{
            System.out.println("Nothing");
        }
    }


}
