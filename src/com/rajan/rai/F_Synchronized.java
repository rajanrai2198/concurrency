package com.rajan.rai;

class Counter implements Runnable {
	private int value = 0;

	public void increment() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException interruptedException) {
			System.out.println("Got Interrrupted...");
		}
		value++;
	}

	public void decrement() {
		value--;
	}

	public int getValue() {
		return value;
	}

	@Override
	public void run() {
		synchronized (this) {
			this.increment();
			System.out.println(Thread.currentThread().getName() + " increment: " + this.getValue());
			this.decrement();
			System.out.println(Thread.currentThread().getName() + " decrement : " + this.getValue());
		}

	}
}

public class F_Synchronized {
	public static void main(String[] args) {
		Counter counter = new Counter();
		new Thread(counter, "one").start();
		new Thread(counter, "two").start();
		new Thread(counter, "three").start();
		new Thread(counter, "four").start();
		new Thread(new Counter(), "Counter2").start();
	}
}
