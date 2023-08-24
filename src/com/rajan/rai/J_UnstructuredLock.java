package com.rajan.rai;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockCounter implements Runnable {
	private int value = 0;
	Lock l = new ReentrantLock();

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
		l.lock();
		try {
			this.increment();
			System.out.println(Thread.currentThread().getName() + " increment: " + this.getValue());
			this.decrement();
			System.out.println(Thread.currentThread().getName() + " decrement : " + this.getValue());
		} finally {
			l.unlock();
		}

	}
}

public class J_UnstructuredLock {
	public static void main(String[] args) {
		LockCounter lockCounter = new LockCounter();
		new Thread(lockCounter, "one").start();
		new Thread(lockCounter, "two").start();
		new Thread(lockCounter, "three").start();
		new Thread(lockCounter, "four").start();
		new Thread(new Counter(), "Counter2").start();
	}
}
