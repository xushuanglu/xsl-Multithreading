package com.ExecutorService.invokeAll.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 方法invokeAll(Collection tasks)全正确
 * @author Administrator
 *
 */
public class Run {

	public static void main(String[] args) {
		try {
			CallableA callableA = new CallableA();
			CallableB callableB = new CallableB();
			List<Callable<String>> list = new ArrayList<Callable<String>>();
			list.add(callableA);
			list.add(callableB);
			
			ExecutorService service = Executors.newCachedThreadPool();
			System.out.println("invokeAll  begin " + System.currentTimeMillis());
			List<Future<String>> listFuture = service.invokeAll(list);
			
			System.out.println("invokeAll   end" + System.currentTimeMillis());
			
			for (int i = 0; i < listFuture.size(); i++) {
				System.out.println("返回结果=" + listFuture.get(i).get() + " " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
	}
}
