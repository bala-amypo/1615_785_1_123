package com.example.demo.model;

public class RunnableEntity implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread executing");
    }
}
