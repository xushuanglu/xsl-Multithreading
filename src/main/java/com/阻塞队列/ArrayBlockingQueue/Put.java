package com.×èÈû¶ÓÁÐ.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Put {

	public static void main(String[] args) {
		ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
		try {
			queue.put("a1");
			queue.put("a2");
			queue.put("a3");
			System.out.println(queue.size());
			System.out.println(System.currentTimeMillis());
			queue.put("a4");
			System.out.println(System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
