package com.udemy.java.test.RunCallable;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class TestRunnable {
    public static void main(String[] args) {

        Runnable r =() -> {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            System.out.println("Hello World");
        };

        new Thread(r).start();

        System.out.println("Hi");
    }
}
