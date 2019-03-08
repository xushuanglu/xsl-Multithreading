package com.thread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的实现
 * @author Administrator
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			
		});
		}
		threadPool.shutdown();//关闭线程池
	}
}
