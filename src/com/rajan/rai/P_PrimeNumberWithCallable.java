package com.rajan.rai;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class P_PrimeNumberWithCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0)
				break;
			Callable<Integer> c = () -> PrimeNumberUtil.calculateNthPrime(n);
			Future<Integer> primeNumberFutures = executorService.submit(c);
			System.out.println(n + "th prime number is " + primeNumberFutures.get());
		}
	}
}