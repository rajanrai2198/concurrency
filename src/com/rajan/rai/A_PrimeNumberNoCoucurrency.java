package com.rajan.rai;

import java.util.Scanner;

public class A_PrimeNumberNoCoucurrency {
	public static void main(String[] args) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("I can tell you nth prime number, Enter number : ");
			int n = sc.nextInt();
			if (n == 0)
				break;
			int number = PrimeNumberUtil.calculateNthPrime(n);
			System.out.println("Value of " + n + "th Prime is : " + number);
		}
	}
}