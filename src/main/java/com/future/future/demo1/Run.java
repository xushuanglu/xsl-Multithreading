package com.future.future.demo1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 方法get()结合ExecutorService中的submit(Callable)的使用
 * @author Administrator
 */
public class Run {

	public static void main(String[] args) {
		try {
			MyCallable myCallable = new MyCallable(100);
			ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque());
			Future<String> future = executor.submit(myCallable);
			System.out.println("main A" + System.currentTimeMillis());
			System.out.println(future.get());
			System.out.println("main B" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
