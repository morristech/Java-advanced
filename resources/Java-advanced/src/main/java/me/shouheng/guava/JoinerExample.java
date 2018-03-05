package me.shouheng.guava;

import com.google.common.base.Joiner;

public class JoinerExample {

    public static void main(String...args) {
        Joiner joiner = Joiner.on(":");
        System.out.println(joiner.join(new String[]{"A", "B", "C"})); // A:B:C

        joiner = joiner.skipNulls();
        System.out.println(joiner.join(new String[]{"A", "B", "C", null, "D"})); // A:B:C:D the null is skipped
    }
}
