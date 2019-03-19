package com.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new MyRecursiveAction());
		Thread.sleep(5000);
	}
}
