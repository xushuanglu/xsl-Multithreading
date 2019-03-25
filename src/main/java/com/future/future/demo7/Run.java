package com.future.future.demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略RejectedExecutionHandler 接口的使用
 * @author Administrator
 *
 */
public class Run {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
		executor.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
		service.submit(new MyRunnable("A"));
		service.submit(new MyRunnable("B"));
		service.submit(new MyRunnable("C"));
		executor.shutdown();
		service.submit(new MyRunnable("D"));
	}
}
