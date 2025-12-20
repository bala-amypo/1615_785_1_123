package com.example.demo.model;

public class ThreadDemoEntity {

    public static void main(String[] args) throws InterruptedException {

        // Thread class
        ThreadEntity t1 = new ThreadEntity();
        t1.start();          // start()
        t1.join();           // join()

        // Runnable interface
        Thread t2 = new Thread(new RunnableEntity());
        t2.start();          // start()

        // Inter-thread communication
        InterThreadEntity obj = new InterThreadEntity();

        Thread producer = new Thread(() -> obj.produce());
        Thread consumer = new Thread(() -> obj.consume());

        producer.start();
        consumer.start();

        System.out.println("Is t1 alive? " + t1.isAlive()); // isAlive()
        Thread.yield();                                     // yield()
    }
}
