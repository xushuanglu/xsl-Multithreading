package com.Executor.ThreadPoolExecutor.demo3;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务被拒绝行为
 * @author Administrator
 *
 */
public class Test1 {

	public static void main(String[] args) {
		MyRunnable myRunnable1 = new MyRunnable("中国1");
		MyRunnable myRunnable2 = new MyRunnable("中国2");
		MyRunnable myRunnable3 = new MyRunnable("中国3");
		MyRunnable myRunnable4 = new MyRunnable("中国4");
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 9999L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		pool.execute(myRunnable1);
		pool.execute(myRunnable2);
		pool.execute(myRunnable3);
		pool.execute(myRunnable4);
	}
}
