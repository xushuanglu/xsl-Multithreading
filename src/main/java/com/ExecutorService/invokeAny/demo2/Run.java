package com.ExecutorService.invokeAny.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 方法invokeAny(CollectionTasks,tomeout,timeUnit)超时的测试
 * @author Administrator
 *
 */
public class Run {

	public static void main(String[] args) {
		try {
			List list = new ArrayList();
			list.add(new MyCallableA());
			ExecutorService executorService = Executors.newCachedThreadPool();
			//invokeAny只取得最先完成任务的结果值
			String getString = (String) executorService.invokeAny(list,1,TimeUnit.SECONDS);
			System.out.println("zzzzz=" + getString);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("mainA");
		} catch (ExecutionException e) {
			e.printStackTrace();
			System.out.println("mainB");
		}catch(TimeoutException e) {
			e.printStackTrace();
			System.out.println("mainC");
		}
		
	}
}
