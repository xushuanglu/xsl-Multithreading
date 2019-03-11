package com.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReenterLock {

	private static ReentrantLock lock = new ReentrantLock();

	private static int i = 0;

	// ѭ��1000000��
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
		// ����join����thread1,thread2������main�̲߳ż������У�����ӡ i
		thread1.join();
		thread2.join();
		// ����lock������ i�����ս��Ϊ 2000000��������ӣ���ֵ�϶�С�ڴ���ֵ
		System.out.println(i);
	}
}
