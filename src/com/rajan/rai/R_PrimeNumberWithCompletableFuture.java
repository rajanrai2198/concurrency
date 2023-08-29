package com.rajan.rai;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class R_PrimeNumberWithCompletableFuture {
	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0)
				break;
			CompletableFuture.supplyAsync(() -> PrimeNumberUtil.calculateNthPrime(n) /* executorService */)
					.thenAccept(System.out::println);
		}
	}
}