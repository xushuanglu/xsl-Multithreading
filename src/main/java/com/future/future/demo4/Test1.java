package com.future.future.demo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务中如果没有执行cancel()方法返回true，代表成功发送取消的命令
   false false
 * @author Administrator
 *
 */
public class Test1 {

	public static void main(String[] args) {
		MyCallable callable = new MyCallable();
		ExecutorService executor = new ThreadPoolExecutor(50, Integer.MAX_VALUE, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		Future<String> future = executor.submit(callable);
		System.out.println(future.cancel(true) + " " + future.isCancelled());
	}
	
}
