package com.concurrent.semaphore.demo1;

import java.util.concurrent.Semaphore;

/**
 * ��Semaphore��ͬ����
 * @author Administrator
 *
 */
public class Service {

	//ͬһʱ���ڣ����������ٸ��߳�ͬʱִ��acquire()��release()֮��Ĵ���
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
