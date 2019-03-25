package com.ExecutorService.invokeAll.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 方法invokeAll(Collection tasks)快的正确慢的异常
 * @author Administrator
 */
public class Run {

	public static void main(String[] args) {
		try {
			List list = new ArrayList();
			list.add(new MyCallableB());
			list.add(new MyCallableA());
			ExecutorService executorService = Executors.newCachedThreadPool();
			System.out.println("Y=" + System.currentTimeMillis());
			List<Future<String>> listFuture = executorService.invokeAll(list);
			System.out.println("Z=" + System.currentTimeMillis());
			for (int i = 0; i < listFuture.size(); i++) {
				System.out.println("result=" + listFuture.get(i).get());
			}
		} catch (InterruptedException e) {
			System.out.println("报错了InterruptedException");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("报错了ExecutionException");
			e.printStackTrace();
		}
		
	}
}
