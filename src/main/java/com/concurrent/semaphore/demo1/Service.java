package com.concurrent.semaphore.demo1;

import java.util.concurrent.Semaphore;

/**
 * 类Semaphore的同步性
 * @author Administrator
 *
 */
public class Service {

	//同一时刻内，最多允许多少个线程同时执行acquire()和release()之间的代码
	private Semaphore semaphore = new Semaphore(1);
	
	public void testMethod() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + "begin time=" + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "end timer = " + System.currentTimeMillis());
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
