package com.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 带返回值的线程
 * @author Administrator
 */
public class Demo1 implements Callable<Integer>{
	
	public static void main(String[] args) throws Exception {
		Demo1 d = new Demo1();
		FutureTask<Integer> task = new FutureTask<>(d);
		Thread t = new Thread(task);
		t.start();
		System.out.println("我先干点别的");
		Integer result = task.get();
		System.out.println("线程执行的结果为： " + result);
		
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("正在进行紧张的计算。");
		Thread.sleep(3000);
		return 1;
	}

}
