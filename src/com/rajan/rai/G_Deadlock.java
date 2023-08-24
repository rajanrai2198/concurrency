package com.rajan.rai;

public class G_Deadlock {
	public static void main(String[] args) {
		final Object resource1 = new Object();
		final Object resource2 = new Object();

		Thread thread1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread 1: Holding resource 1...");
				try {
					Thread.sleep(100); // Introducing a delay to increase the chances of deadlock
				} catch (InterruptedException e) {
				}
				System.out.println("Thread 1: Waiting for resource 2...");
				synchronized (resource2) {
					System.out.println("Thread 1: Holding resource 1 and resource 2...");
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread 2: Holding resource 2...");
				System.out.println("Thread 2: Waiting for resource 1...");
				synchronized (resource1) {
					System.out.println("Thread 2: Holding resource 1 and resource 2...");
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
