package com.Executor.ThreadPoolExecutor.demo1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(7,10,0L,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
		System.out.println("main end!");
		
	}
}
