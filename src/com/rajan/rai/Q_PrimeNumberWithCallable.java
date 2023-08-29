package com.rajan.rai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q_PrimeNumberWithCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Callable<Integer>> callableList = new ArrayList<>();
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0)
				break;
			Callable<Integer> c = new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					return PrimeNumberUtil.calculateNthPrime(n);
				}
			};
			callableList.add(c);
		}
		List<Future<Integer>> futures = executorService.invokeAll(callableList);
		Iterator<Future<Integer>> iterator = futures.iterator();
		while (iterator.hasNext()) {
			Future<Integer> f = iterator.next();
			if (f.isDone()) {
				System.out.println(f.get());
				iterator.remove();
			}
		}
	}
}