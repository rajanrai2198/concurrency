package com.rajan.rai;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class N_PrimeNumberWithScheduledExecuterService {
	public static void main(String[] args) {
		ThreadPoolExecutor exectorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		Runnable reporterRunnable = () -> {
			System.out.println("Active thread :: " + exectorService.getActiveCount());
			System.out.println("Completed thread :: " + exectorService.getCompletedTaskCount());
		};

		scheduledExecutorService.scheduleAtFixedRate(reporterRunnable, 1, 5, TimeUnit.SECONDS);

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