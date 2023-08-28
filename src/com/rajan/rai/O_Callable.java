package com.rajan.rai;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class O_Callable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> c = new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("printing from call...");
				Thread.sleep(2000);
				return "value from call";
			}
		};
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> submit = executorService.submit(c);
		System.out.println("Executing main Thread....");
		System.out.println("Executing main Thread....");
		System.out.println("Executing main Thread....");
		String s = submit.get();
		System.out.println("Call able retured :: " + s);
	}
}