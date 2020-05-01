package com.udemy.java.test.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamOfDemo {

    public static void main(String[] args) {

        String a ="Apple";
        String b = "Delta";
        String c = "Cat";

        Optional<String> smallestString = getSmallestString(a, b, c);
        if(smallestString.isPresent()){
            System.out.println(smallestString.get().toUpperCase());
        }
        else{
            System.out.println("Nothing Found");
        }
    }
    private static Optional<String> getSmallestString(String var1, String var2, String var3){

        return Stream.of(var1,var2,var3).min(Comparator.naturalOrder());
    }
}

