package com.future.future.demo7;

public class MyRunnable implements Runnable{
	
	private String username;
	
	public MyRunnable(String username) {
		super();
		this.username = username;
	}

	@Override
	public void run() {
		System.out.println(username + " ������! ");
	}

}
