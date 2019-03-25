package com.future.future.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 方法get()结合ExecutorService中的submit(Runnable)和isDone()的使用
 * @author Administrator
 */
public class Run {

	public static void main(String[] args) {
		try {
			Runnable runnable = new Runnable() {
				
				@Override
				public void run() {
					System.out.println("打印的信息");
				}
			};
			ExecutorService executorRef = Executors.newCachedThreadPool();
			Future future = executorRef.submit(runnable);
			System.out.println(future.get() + " " + future.isDone());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
