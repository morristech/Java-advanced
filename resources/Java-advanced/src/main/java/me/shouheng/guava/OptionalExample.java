package me.shouheng.guava;

import com.google.common.base.Optional;

public class OptionalExample {

    public static void main(String...args) {
        Integer integer1 = null, integer2 = 2;
        Optional<Integer> optional1 = Optional.fromNullable(integer1);
        Optional<Integer> optional2 = Optional.fromNullable(integer2);
        System.out.println(sum(optional1, optional2));
    }

    private static Integer sum(Optional<Integer> val1, Optional<Integer> val2) {
        System.out.println("Val1 is present :" + val1.isPresent() + ", Val2 is present :" + val2.isPresent());
        Integer integer1 = val1.or(3);
        Integer integer2 = val2.or(2);
        return integer1 + integer2;
    }
}
