package com.rajan.rai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E_PrimeNumberWithConcurrencyJoin {
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();

		Runnable statusReporter = () -> {
			try {
				while (true) {
					Thread.sleep(5000);
					printThreads(threads);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted.....");
			}

		};

		Thread reportThread = new Thread(statusReporter);
		reportThread.start();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0) {
				reportThread.interrupt();
				try {
					System.out.println("Waithing for all threads to end.");
					waitForThread(threads);
					System.out.println("Done! " + threads.size() + " prime calculated");
				} catch (InterruptedException e) {
					System.out.println("Got Interupted while waiting for thread.");
				}
				break;
			}
			Runnable r = new Runnable() {
				@Override
				public void run() {
					int number = PrimeNumberUtil.calculateNthPrime(n);
					System.out.println("Value of " + n + "th Prime is : " + number);
				}
			};
			Thread t = new Thread(r);
			threads.add(t);
			t.start();
		}
	}

	private static void waitForThread(List<Thread> threads) throws InterruptedException {
		for (Thread t : threads) {
//			if (!t.getState().equals(Thread.State.TERMINATED)) {
			t.join();
//			}
		}
	}

	private static void printThreads(List<Thread> threads) {
		System.out.println("Thread Status :: ");
		for (Thread t : threads) {
			System.out.println(t.getState());
		}
	}

}