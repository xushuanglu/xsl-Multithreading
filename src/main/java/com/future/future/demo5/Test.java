package com.future.future.demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {
		try {
			MyCallable callable = new MyCallable();
			ExecutorService executor = new ThreadPoolExecutor(50, Integer.MAX_VALUE, 5, TimeUnit.SECONDS,
					new LinkedBlockingDeque<Runnable>());
			Future<String> future = executor.submit(callable);
			Thread.sleep(4000);
			System.out.println(future.cancel(true) + " " + future.isCancelled());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
