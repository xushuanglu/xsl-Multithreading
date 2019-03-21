package com.×èÈû¶ÓÁÐ.PriorityBlockingQueue;

import java.util.concurrent.PriorityBlockingQueue;

public class Test {

	public static void main(String[] args) {
		PriorityBlockingQueue<UserInfo> queue = new PriorityBlockingQueue<UserInfo>();
		queue.add(new UserInfo(12));
		queue.add(new UserInfo(13478));
		queue.add(new UserInfo(1569));
		queue.add(new UserInfo(1346));
		queue.add(new UserInfo(1762));
		queue.add(new UserInfo(1876876));
		
		System.out.println(queue.poll().getId());
		System.out.println(queue.poll().getId());
		System.out.println(queue.poll().getId());
		System.out.println(queue.poll().getId());
		System.out.println(queue.poll().getId());
		System.out.println(queue.poll().getId());
		System.out.println(queue.poll());
	}
}
