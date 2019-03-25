package com.CompletionService.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletionService使用take()方法
 * 方法take()是按任务执行的速度，从快到慢顺序获得Future对象，因为打印的时间是从小到大。
 * 
 *  sleep=931 pool-1-thread-5
	sleep=945 pool-1-thread-3
	sleep=291 pool-1-thread-2
	sleep=16 pool-1-thread-6
	sleep=834 pool-1-thread-1
	sleep=801 pool-1-thread-7
	sleep=344 pool-1-thread-8
	sleep=84 pool-1-thread-9
	sleep=277 pool-1-thread-4
	sleep=494 pool-1-thread-10
	高洪岩：16 pool-1-thread-6
	高洪岩：84 pool-1-thread-9
	高洪岩：277 pool-1-thread-4
	高洪岩：291 pool-1-thread-2
	高洪岩：344 pool-1-thread-8
	高洪岩：494 pool-1-thread-10
	高洪岩：801 pool-1-thread-7
	高洪岩：834 pool-1-thread-1
	高洪岩：931 pool-1-thread-5
	高洪岩：945 pool-1-thread-3
 * @author Administrator
 *
 */
public class Run {

	public static void main(String[] args) {
		try {
			ExecutorService executorService = Executors.newCachedThreadPool();
			CompletionService csRef = new ExecutorCompletionService(executorService);
			for (int i = 0; i < 10; i++) {
				csRef.submit(new Callable<String>() {

					@Override
					public String call() throws Exception {
						long sleepValue = (int) (Math.random() * 1000);
						System.out.println("sleep=" + sleepValue + " " + Thread.currentThread().getName());
						Thread.sleep(sleepValue);
						return "高洪岩：" + sleepValue + " " + Thread.currentThread().getName();
					}

				});
			}
			for (int i = 0; i < 10; i++) {
				System.out.println(csRef.take().get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
