package com.udemy.java.test.util;

public class TestMain {
    public static void main(String[] args) {

        //200 - Site is reachable - Correct Link.
        //404 - Something wrong at our end.
        //0   - Host does not exist.
        //500 - Server Issue
        System.out.println(
                LinkUtil.getResponseCode("https://www.google123.com/")

        );
    }
}
