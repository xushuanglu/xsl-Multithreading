package com.Executor.ThreadPoolExecutor.demo1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务执行完成后池继续等待新的任务
 * @author Administrator
 */
public class Test2 {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(7,10,0L,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
		pool.execute(myRunnable);
		System.out.println("main end!");
		
	}
}
