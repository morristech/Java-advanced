package me.shouheng.guava;

import com.google.common.base.Splitter;

public class SplitterExample {

    public static void main(String...args) {
        Splitter.on(':').split("A:B:C:D").forEach(System.out::print);
        System.out.println();
        Splitter.on(",").limit(3).trimResults().split(" a,  b,  c,  d").forEach(System.out::print);
        System.out.println();
        Splitter.on(",").trimResults().limit(3).split(" a,  b,  c,  d").forEach(System.out::print);
        System.out.println();
        Splitter.on(";").withKeyValueSeparator(":").split("a:1;b:2;c:3").forEach((s, s2) -> System.out.print(s + "" + s2));
    }
}
