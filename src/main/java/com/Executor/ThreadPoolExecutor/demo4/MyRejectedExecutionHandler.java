package com.Executor.ThreadPoolExecutor.demo4;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import com.Executor.ThreadPoolExecutor.demo3.MyRunnable;

public class MyRejectedExecutionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(((MyRunnable)r).getUsername() + "±»¾Ü¾øÖ´ÐÐ");
	}

}
