package com.rajan.rai;

public class PrimeNumberUtil {

	public static int calculateNthPrime(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n must be a positive integer");
		}

		int count = 0;
		int number = 2; // Start checking from the first prime number

		while (count < n) {
			if (isPrime(number)) {
				count++;
			}
			number++;
		}

		return number - 1; // Adjust for the extra increment after finding the nth prime
	}

	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		if (num <= 3) {
			return true;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

}
