package com.ExecutorService.executorservice;

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
			list.add(new MyCallableB1());
			ExecutorService executorService = Executors.newCachedThreadPool();
			//invokeAny只取得最先完成任务的结果值
			String getValueA = (String) executorService.invokeAny(list);
			System.out.println("=============================" + getValueA);
			System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
