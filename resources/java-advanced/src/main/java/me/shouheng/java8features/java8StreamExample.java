package me.shouheng.java8features;

import java.util.Arrays;
import java.util.List;

public class java8StreamExample {
    public static void main(String...args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("----------------Stream#allMatch----------------");
        System.out.println(list.stream().allMatch(integer -> integer > 0));
        System.out.println(list.stream().allMatch(integer -> integer > 1));

        System.out.println("----------------Stream#forEach----------------");
        list.stream().forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("----------------Stream#anyMatch----------------");
        System.out.println(list.stream().anyMatch(integer -> integer > 5));
        System.out.println(list.stream().anyMatch(integer -> integer > 10));

        System.out.println("----------------Stream#count----------------");
        System.out.println(list.stream().count());

        System.out.println("----------------Stream#distinct----------------");
        list.stream().distinct().forEach(integer -> System.out.print(integer + " "));
        System.out.println();

        System.out.println("----------------Stream#filter----------------");
        list.stream().filter(integer -> integer > 4).forEach(integer -> System.out.print(integer + " "));
        System.out.println();
    }
}
