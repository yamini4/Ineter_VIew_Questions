package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExamplUsingExecutorService {
    public static void main(String[] args) throws InterruptedException {

        long numOfThreads = 50000;
        ExecutorService executor = Executors.newFixedThreadPool(50);

        Counter counter = new Counter();

        for (int i = 0; i < numOfThreads; i++) {
            executor.submit(counter::increment);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(1000);
        }
        System.out.println("Final Count: " + counter.getCount());
    }

}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        System.out.println("count :" + count);
        count++;
    }

    public int getCount() {
        return count;
    }
}
