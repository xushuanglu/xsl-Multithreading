package com.×èÈû¶ÓÁÐ.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Take {

	public static void main(String[] args) {
		try {
			ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
			System.out.println("begin " + System.currentTimeMillis());
			System.out.println(queue.take());
			System.out.println("end " + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
