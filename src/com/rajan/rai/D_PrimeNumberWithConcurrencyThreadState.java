package com.rajan.rai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_PrimeNumberWithConcurrencyThreadState {

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();

		Runnable statusReporter = () -> {
			try {
				while (true) {
					Thread.sleep(3000);
					printThreads(threads);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread reportThread = new Thread(statusReporter);
		reportThread.setDaemon(true);
		reportThread.start();

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0)
				break;
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

	private static void printThreads(List<Thread> threads) {
		System.out.println("Thread Status :: ");
		for (Thread t : threads) {
			System.out.println(t.getState());
		}
	}
}