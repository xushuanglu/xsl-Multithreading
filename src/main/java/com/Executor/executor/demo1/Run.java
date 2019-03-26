package com.Executor.executor.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ʹ��newCachedThreadPool()���������޽��̳߳�
 * @author Administrator
 */
public class Run {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("Runnable1 begin " + System.currentTimeMillis());
					Thread.sleep(1000);
					System.out.println("A");
					System.out.println("Runnable1 end " + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Runnable2 begin " + System.currentTimeMillis());
					Thread.sleep(1000);
					System.out.println("B");
					System.out.println("Runnable2 end " + System.currentTimeMillis());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
}
