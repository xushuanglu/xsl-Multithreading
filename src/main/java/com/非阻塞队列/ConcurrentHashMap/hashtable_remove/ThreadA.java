package com.·Ç×èÈû¶ÓÁÐ.ConcurrentHashMap.hashtable_remove;

import java.util.Iterator;

public class ThreadA extends Thread {

	private MyService4 service;

	public ThreadA(MyService4 service) {
		super();
		this.service = service;
	}

	public void run() {

		try {
			Iterator iterator = service.map.keySet().iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.hasNext());
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
