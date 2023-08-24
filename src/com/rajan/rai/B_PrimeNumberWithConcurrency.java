package com.rajan.rai;

import java.util.Scanner;

public class B_PrimeNumberWithConcurrency {
	public static void main(String[] args) {
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
			t.start();
		}
	}
}