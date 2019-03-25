package com.future.future.demo6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ����get(long timeout,TimeUnit unit)��ʹ��
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {
		try {
			MyCallable callable = new MyCallable();
			ExecutorService executor = new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS,
					new LinkedBlockingDeque());
			System.out.println("begin " + System.currentTimeMillis());
			Future<String> future = executor.submit(callable);
			System.out.println("����ֵ" + future.get(5, TimeUnit.SECONDS));
			System.out.println("end " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			System.out.println("���� catch InterruptedException");
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("���� catch ExecutionException ");
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("���� catch TimeoutException ");
			e.printStackTrace();
		}
	}

}
