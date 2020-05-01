package com.udemy.java.test.stream;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        // Traditional Way
        int value=0;
      /*  for (int i = 0; i <list.size() ; i++) {
            if(list.get(i)%2==0){
                int val = list.get(i);
                value=val*val;
                System.out.println(value);
            }

        }*/

        // With Stream Implementation
        list
                // All values at Stream Level
                .stream()
                // Filter - allow even numbers
                .filter(i -> {
                    System.out.println("Filter-Received :: " +i);
                    return i%2==0;
                })
                // Limit to 3 (Max)
                .limit(3)
                //Finds Square
                .map(i-> {
                    System.out.println("Map - Received :: " + i);
                    return i*i;
                })
                // Printing the result
                .forEach(System.out::println);

        }
    }

