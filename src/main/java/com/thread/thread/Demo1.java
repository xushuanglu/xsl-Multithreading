package com.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * ������ֵ���߳�
 * @author Administrator
 */
public class Demo1 implements Callable<Integer>{
	
	public static void main(String[] args) throws Exception {
		Demo1 d = new Demo1();
		FutureTask<Integer> task = new FutureTask<>(d);
		Thread t = new Thread(task);
		t.start();
		System.out.println("���ȸɵ���");
		Integer result = task.get();
		System.out.println("�߳�ִ�еĽ��Ϊ�� " + result);
		
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("���ڽ��н��ŵļ��㡣");
		Thread.sleep(3000);
		return 1;
	}

}
