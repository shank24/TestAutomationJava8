package com.udemy.java.test.RunCallable;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import static java.lang.System.*;

public class TestCallable {
    public static void main(String[] args) throws Exception {

        Supplier<Double> random =  () -> Math.random();
        Callable<Double> random1 = () -> Math.random();

        out.println(random.get());
        out.println(random1.call());
        test(random1);
    }

    private static void test(Callable callable) throws Exception {
        out.println(callable.call());
    }
}
