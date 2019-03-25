package com.ExecutorService.invokeAny.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {

	public static void main(String[] args) {
		try {
			List list = new ArrayList();
			list.add(new MyCallableA());
			list.add(new MyCallableB());
			ExecutorService executorService = Executors.newCachedThreadPool();
			//invokeAny只取得最先完成任务的结果值
			String getString = (String) executorService.invokeAny(list);
			System.out.println("zzzzz=" + getString);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
