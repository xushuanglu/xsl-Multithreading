package com.��������.DelayQueue;

import java.util.concurrent.DelayQueue;

/**
 * ��DelayQueue�ṩһ����ʱִ������Ķ���
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		DelayQueue<UserInfo> queue = new DelayQueue<UserInfo>();
		queue.add(new UserInfo(7,"username5"));
		queue.add(new UserInfo(6,"username4"));
		queue.add(new UserInfo(5,"username3"));
		queue.add(new UserInfo(4,"username2"));
		queue.add(new UserInfo(3,"username1"));
		
		System.out.println("              " + System.currentTimeMillis());
		System.out.println(queue.take().getUsername() + " "  + System.currentTimeMillis());
		System.out.println(queue.take().getUsername() + " "  + System.currentTimeMillis());
		System.out.println(queue.take().getUsername() + " "  + System.currentTimeMillis());
		System.out.println(queue.take().getUsername() + " "  + System.currentTimeMillis());
		System.out.println(queue.take().getUsername() + " "  + System.currentTimeMillis());
		
		
	}
}
