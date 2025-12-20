package com.example.demo.model;

public class InterThreadEntity {

    int value;

    synchronized void produce() {
        try {
            System.out.println("Producing value...");
            value = 10;
            wait();                 // wait()
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    synchronized void consume() {
        System.out.println("Consuming value: " + value);
        notify();                  // notify()
    }
}
