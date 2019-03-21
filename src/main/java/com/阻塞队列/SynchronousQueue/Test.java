package com.×èÈû¶ÓÁÐ.SynchronousQueue;

import java.util.concurrent.SynchronousQueue;

public class Test {

	public static void main(String[] args) {
		try {
			SynchronousQueue queue = new SynchronousQueue();
			System.out.println("step1");
			queue.put("anyString");
			System.out.println("step2");
			System.out.println(queue.take());
			System.out.println("step3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
