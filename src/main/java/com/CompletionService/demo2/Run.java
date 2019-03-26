package com.CompletionService.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletionServiceʹ��take()����
 * ����take()�ǰ�����ִ�е��ٶȣ��ӿ쵽��˳����Future������Ϊ��ӡ��ʱ���Ǵ�С����
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
	�ߺ��ң�16 pool-1-thread-6
	�ߺ��ң�84 pool-1-thread-9
	�ߺ��ң�277 pool-1-thread-4
	�ߺ��ң�291 pool-1-thread-2
	�ߺ��ң�344 pool-1-thread-8
	�ߺ��ң�494 pool-1-thread-10
	�ߺ��ң�801 pool-1-thread-7
	�ߺ��ң�834 pool-1-thread-1
	�ߺ��ң�931 pool-1-thread-5
	�ߺ��ң�945 pool-1-thread-3
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
						return "�ߺ��ң�" + sleepValue + " " + Thread.currentThread().getName();
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
