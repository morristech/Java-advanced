package me.shouheng.guava;

import com.google.common.base.Preconditions;

public class PreconditionsExample {

    public static void main(String...args) {
        try {
            Preconditions.checkArgument(args == null, "the test args is null");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
