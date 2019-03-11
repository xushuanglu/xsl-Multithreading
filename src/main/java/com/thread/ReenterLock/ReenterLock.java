package com.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReenterLock {

	private static ReentrantLock lock = new ReentrantLock();

	private static int i = 0;

	// 循环1000000次
	private static Runnable runnable = () -> IntStream.range(0, 1000000).forEach((j) -> {
		lock.lock();
		try {
			i++;
		} finally {
			lock.unlock();
		}
	});

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread2.start();
		// 利用join，等thread1,thread2结束后，main线程才继续运行，并打印 i
		thread1.join();
		thread2.join();
		// 利用lock保护的 i，最终结果为 2000000，如果不加，则值肯定小于此数值
		System.out.println(i);
	}
}
