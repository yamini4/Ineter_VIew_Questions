package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExamplUsingExecutorService {
	public static void main(String[] args) throws InterruptedException {

		long numOfThreads = 50000;
		ExecutorService executor = Executors.newFixedThreadPool(50);

		Counter1 counter = new Counter1();

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

class Counter1 {
	private int count = 0;

	public synchronized void increment() {
		System.out.println("count :" + count);
		count++;
	}

	public int getCount() {
		return count;
	}
}
