package com.thread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳ص�ʵ��
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
		threadPool.shutdown();//�ر��̳߳�
	}
}
