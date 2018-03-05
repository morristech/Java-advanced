package me.shouheng.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusExample {

    public static void main(String...args) {
        EventBus eventBus = new EventBus("Joker");
        eventBus.register(new EventListener());
        eventBus.register(new EventListener2());
        eventBus.post(new Event("Hello every listener, joke begins..."));
        eventBus.post("How about the joke?");
    }

    public static class Event {
        public String message;

        Event(String message) {
            this.message = message;
        }
    }

    public static class EventListener {

        @Subscribe
        public void listen(Event event) {
            System.out.println("Event listener 1 event.message = " + event.message);
        }

        @Subscribe
        public void listen(String msg) {
            System.out.println("Event listener 1 msg = " + msg);
        }
    }

    public static class EventListener2 {
        @Subscribe
        public void listen(Event event) {
            System.out.println("Event listener 2 event.message = " + event.message);
        }

        @Subscribe
        public void listen(String msg) {
            System.out.println("Event listener 2 msg = " + msg);
        }
    }
}
