package com.thread.ReenterLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有限时间的等待锁
 * 
 * 这里使用tryLock()第一个获取锁的线程，会停止5秒。而获取锁的设置为3秒获取不到锁则放弃，所以第二个去尝试获取锁的线程是获取不到锁而被迫停止的。
 * 如果tryLock()方法不传入任何参数，那么获取锁的线程不会等待锁，则立即返回false。
 * @author Administrator
 *
 */
public class ReenterTryLock {
	private static ReentrantLock reenterLock = new ReentrantLock();

	private static Runnable runnable = () -> {
		try {
			// tryLock()方法会返回一个布尔值，获取锁成功则为true
			if (reenterLock.tryLock(3, TimeUnit.SECONDS)) {
				Thread.sleep(5000);
			} else {
				System.out.println(Thread.currentThread().getName() + "获取锁失败");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 最后，如果当前前程在持有锁，则释放锁
			if (reenterLock.isHeldByCurrentThread()) {
				System.out.println(Thread.currentThread().getName() + "释放锁了");
				reenterLock.unlock();
			}
		}
	};

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable, "thread-1");
		Thread thread2 = new Thread(runnable, "thread-2");

		thread1.start();
		thread2.start();
	}
}
