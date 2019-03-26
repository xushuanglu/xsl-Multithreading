package com.CompletionService.demo3;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ����poll()���ص�FutureΪnull����Ϊ��ǰû���κ�����������Future����
 * poll()��������take()��������������Ч��
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
					System.out.println("3�������");
					return "��˫· 3s";
				}
				
			});
		}
		for (int i = 0; i < 1; i++) {
			System.out.println(csRef.poll());
		}
	}
}
