package com.future.future.demo1;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private int age;
	
	public MyCallable(int age) {
		super();
		this.age = age;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(8000);
		return "����ֵ �����ǣ�" + age;
	}

}
