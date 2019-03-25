package com.future.future.demo6;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		Thread.sleep(10000);
		System.out.println("sleep 10√Î÷¥––ÕÍ¡À£°");
		return "anyString";
	}

}
