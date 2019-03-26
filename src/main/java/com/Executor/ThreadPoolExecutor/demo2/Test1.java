package com.Executor.ThreadPoolExecutor.demo2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		try {
			MyRunnable1 myRunnable1 = new MyRunnable1();
			ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 99999, 9999L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
			pool.execute(myRunnable1);
			pool.execute(myRunnable1);
			pool.execute(myRunnable1);
			pool.execute(myRunnable1);
			Thread.sleep(1000);
			pool.shutdownNow();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
