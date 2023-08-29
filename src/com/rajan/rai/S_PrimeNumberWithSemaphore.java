package com.rajan.rai;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class S_PrimeNumberWithSemaphore {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3, true);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0)
				break;
			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						semaphore.acquire();
						int number = PrimeNumberUtil.calculateNthPrime(n);
						System.out.println("Value of " + n + "th Prime is : " + number);
					} catch (InterruptedException interruptedException) {
						System.out.println("Interrupted.........");
					} finally {
						semaphore.release();
					}
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
	}
}