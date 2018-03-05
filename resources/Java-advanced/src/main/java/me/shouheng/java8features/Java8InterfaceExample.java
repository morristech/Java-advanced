package me.shouheng.java8features;

public class Java8InterfaceExample {

    public static void main(String ...args) {
        MyInterface1 myInterface1 = new MyInterface1();
        MyInterface2 myInterface2 = new MyInterface2();

        /**
         * use default implementation */
        myInterface1.sayHello();

        /**
         * use override implementation */
        myInterface2.sayHello();

        /**
         * use static method to create an instance */
        DefaultInterface.create().sayHello();
    }

    private static class MyInterface1 implements DefaultInterface { }

    private static class MyInterface2 implements DefaultInterface {

        @Override
        public void sayHello() {
            System.out.println("Hello default my interface 2 method!");
        }
    }

    private interface DefaultInterface {

        static DefaultInterface create() {
            return new DefaultInterface() {
                @Override
                public void sayHello() {
                    System.out.println("Hello from static create method!");
                }
            };
        }

        default void sayHello() {
            System.out.println("Hello default interface method!");
        }
    }
}
