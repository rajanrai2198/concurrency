package com.rajan.rai;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_PrimeNumberWithExecuterService {
	public static void main(String[] args) {
		ExecutorService exectorService = Executors.newFixedThreadPool(3);
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
			exectorService.execute(r);
		}
	}
}