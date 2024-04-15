package com.example.day09;

import java.beans.EventHandler;

public class EventProcessor {
    public void processEvent(String event) {
        class EventHandler {
            public void handle() {
                System.out.println("Event: " + event);
            }
        }
        EventHandler eventHandler = new EventHandler();
        eventHandler.handle();
    }

    public static void main(String[] args) {
        EventProcessor eventProcessor = new EventProcessor();
        eventProcessor.processEvent("Event");
    }

}
