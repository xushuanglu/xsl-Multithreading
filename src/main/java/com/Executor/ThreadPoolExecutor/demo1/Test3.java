package com.Executor.ThreadPoolExecutor.demo1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ���pool.shutdown();
 * ����ִ����ɺ���̽���
 * @author Administrator
 */
public class Test3 {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(7,10,0L,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
		pool.execute(myRunnable);
		pool.shutdown();
		System.out.println("main end!");
		
	}
}
