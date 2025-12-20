package com.example.demo.model;

public class ThreadEntity extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Thread started");

            Thread.sleep(1000);   // sleep()

            System.out.println("Thread running");

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
