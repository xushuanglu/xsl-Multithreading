package com.future.future.demo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用ExecutorService接口中的方法submit(Runnable,T result)
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {
		try {
			Userinfo userinfo = new Userinfo();
			MyRunnable myRunnable = new MyRunnable(userinfo);
			
			ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
			Future<Userinfo> future = pool.submit(myRunnable,userinfo);
			System.out.println("begin time=" + System.currentTimeMillis());
			userinfo = future.get();
			System.out.println("get value " + userinfo.getUsername() + " " + userinfo.getPassword());
			System.out.println(" end time=" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
