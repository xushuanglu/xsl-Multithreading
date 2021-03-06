package com.thread.ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程中断响应
 * 如果线程阻塞于synchronized，那么要么获取到锁，继续执行，要么一直等待。
 * 重入锁提供了另一种可能，就是中断线程。下面的例子是利用两个线程构建一个死锁，然后中断其中一个线程，
 * 
 * thread-1拿到锁之后，线程即持有锁并等待20秒，然后thread-2启动，并没有拿到锁，这时候中断thread-2线程，线程2退出。
 * @author Administrator
 */
public class ReenterLockInterrupt {
	private static ReentrantLock lock = new ReentrantLock();

	private static Runnable runnable = () -> {
		try {
			// 利用 lockInterruptibly 申请锁,这是可以进中断申请的申请锁操作
			lock.lockInterruptibly();
			// 睡眠20秒，在睡眠结束之前，main方法里要中断thread2的获取锁操作
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			String threadName = Thread.currentThread().getName();
			// 中断后抛出异常，最后要释放锁
			// 如果是线程1则释放锁，因为线程2就没拿到锁，所以不用释放
			if ("Thread-1".equals(threadName))
				lock.unlock();
			System.out.println(threadName + " 停止");
		}
	};

	public static void main(String[] args) {
		Thread thread1 = new Thread(runnable, "thread-1");
		Thread thread2 = new Thread(runnable, "thread-2");
		thread1.start();

		// 让主线程停一下，让thread1获取锁后再启动thread2
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// 这里什么也不做
		}

		thread2.start();
		thread2.interrupt();
	}
}
