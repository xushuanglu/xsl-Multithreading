package com.·Ç×èÈû¶ÓÁÐ.ConcurrentSkipListSet;

import java.util.Map.Entry;

public class ThreadA extends Thread{

	private MyService1 service;
	public ThreadA(MyService1 service) {
		super();
		this.service = service;
	}
	
	public void run() {
		while(!service.map.isEmpty()) {
			try {
				UserInfo userInfo = (UserInfo) service.map.pollFirst();
				System.out.println(userInfo.getId() + " " + userInfo.getUsername() );
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
