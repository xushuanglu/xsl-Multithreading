package com.Executor.executor.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ʹ��newCachedThreadPool()���������޽��̳߳�
 * @author Administrator
 */
public class Run2 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("run!");
				}
			});
			
		}
		
	}
}
