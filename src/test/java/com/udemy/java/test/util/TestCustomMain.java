package com.udemy.java.test.util;

public class TestCustomMain {

    public static void main(String[] args) {

        CustomList customList = new CustomArrayList();
        customList.add(1);
        customList.add(2);
        customList.add(3);

        customList.forEach(i -> System.out.println(i*i));




    }
}
