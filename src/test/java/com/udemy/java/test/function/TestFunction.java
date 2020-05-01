package com.udemy.java.test.function;

import java.util.function.Function;

public class TestFunction {

    public static void main(String[] args) {

        Function<String,Integer> strLen = (s) -> s.length();
        Function<Integer,Integer> square = (i) -> i*i;

        System.out.println(strLen.apply("SFSDFSDFSDFSDF"));

        // This strLen returns length
        // and it uses it as an input for square()

        //5 -> 5*5
        System.out.println(strLen.andThen(square).apply("UDEMY"));

        Function<Integer,Integer> plus2 = (i) -> i+2;
        System.out.println(plus2.apply(6));

        //10 - > 10*10 = 100
        //andThen -> a.andThen(b) => a -> b
        System.out.println(plus2.andThen(square).apply(8));

        //8*8 => 64+2 = 66
        //compose -> a.compose(b) => b -> a
        System.out.println(plus2.compose(square).apply(8));




    }

}
