package com.thread.ReenterLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * thread–1启动，拿到锁，然后进入等待并且释放锁，2秒后，主线程拿到锁，然后发出信号并释放锁，最后，thread–1继续执行。
 * @author Administrator
 */
public class ReenterLockCondition {
	private static ReentrantLock lock = new ReentrantLock();

	private static Condition condition = lock.newCondition();

	private static Runnable runnable = () -> {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "进入等待。。");
			condition.await();
			System.out.println(Thread.currentThread().getName() + "继续执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	};

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(runnable, "thread--1");
		thread.start();

		Thread.sleep(2000);

		lock.lock();
		condition.signal();
		System.out.println("主线程发出信号");
		lock.unlock();
	}
}
