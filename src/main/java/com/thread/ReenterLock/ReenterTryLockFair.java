package com.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * 
 * 公平锁与非公平锁

当一个线程释放锁时，其他等待的线程则有机会获取锁，如果是公平锁，则分先来后到的获取锁，如果是非公平锁则谁抢到锁算谁的，这就相当于排队买东西和不排队买东西是一个道理。Java的synchronized关键字就是非公平锁。

那么重入锁ReentrantLock()是公平锁还是非公平锁？

重入锁ReentrantLock()是可以设置公平性的，可以参考其构造方法：

// 通过传入一个布尔值来设置公平锁，为true则是公平锁，false则为非公平锁
public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }
 * @author Administrator
 *
 */
public class ReenterTryLockFair {
	// 分别设置公平锁和非公平锁，分析打印结果
	private static ReentrantLock lock = new ReentrantLock(true);

	private static Runnable runnable = () -> {
		while (true) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + " 获取了锁");
			} finally {
				lock.unlock();
			}
		}
	};

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable, "thread---1");
		Thread thread2 = new Thread(runnable, "thread---2");
		Thread thread3 = new Thread(runnable, "thread---3");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
