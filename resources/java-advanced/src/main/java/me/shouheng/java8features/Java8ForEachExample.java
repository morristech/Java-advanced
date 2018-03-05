package me.shouheng.java8features;

import java.util.Arrays;
import java.util.List;

public class Java8ForEachExample {

    public static void main(String...args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        /**
         * forEach方法在内部使用for循环并调用传入的接口的方法，属于策咯模式。*/
        list.forEach(System.out::println);
    }
}
