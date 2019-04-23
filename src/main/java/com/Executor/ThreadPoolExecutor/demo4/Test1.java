package com.Executor.ThreadPoolExecutor.demo4;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.Executor.ThreadPoolExecutor.demo3.MyRunnable;

/**
 * �ܾ�ִ��������־��
 * @author Administrator
 *
 */
public class Test1 {

	public static void main(String[] args) {
		MyRunnable myRunnable1 = new MyRunnable("�й�1");
		MyRunnable myRunnable2 = new MyRunnable("�й�2");
		MyRunnable myRunnable3 = new MyRunnable("�й�3");
		MyRunnable myRunnable4 = new MyRunnable("�й�4");
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 9999L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		pool.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
		pool.execute(myRunnable1);
		pool.execute(myRunnable2);
		pool.execute(myRunnable3);
		pool.execute(myRunnable4);
	}
}
