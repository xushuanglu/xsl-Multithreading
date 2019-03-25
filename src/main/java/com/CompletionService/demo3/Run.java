package com.CompletionService.demo3;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 方法poll()返回的Future为null，因为当前没有任何已完成任务的Future对象
 * poll()方法不像take()方法具有阻塞的效果
 * @author Administrator
 *
 */
public class Run {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CompletionService csRef = new ExecutorCompletionService<>(executorService);
		for (int i = 0; i < 1; i++) {
			csRef.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					Thread.sleep(3000);
					System.out.println("3秒过后了");
					return "徐双路 3s";
				}
				
			});
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(csRef.poll());
		}
	}
}
