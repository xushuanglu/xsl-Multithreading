package com.·Ç×èÈû¶ÓÁÐ.ConcurrentSkipListMap;

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
				Entry entry = service.map.pollFirstEntry();
				UserInfo userInfo = (UserInfo) entry.getKey();
				System.out.println(userInfo.getId() + " " + userInfo.getUsername() + " " + entry.getValue());
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
