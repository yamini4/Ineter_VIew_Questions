package com.example;

public class SyncsThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int numThreads = 500000;

        Thread[] threads = new Thread[numThreads];

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
