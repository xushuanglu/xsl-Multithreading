package com.Executor.executor.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 验证newCachedThreadPool()创建为线程池
 * @author Administrator
 *
 */
public class Run {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			executorService.execute(new MyRunnable(("" + (i + 1))));
		}
	}
}
