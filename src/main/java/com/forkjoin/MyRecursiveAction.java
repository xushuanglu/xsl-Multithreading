package com.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * 使用  RecursiveAction让任务跑起来
 * @author Administrator
 */
public class MyRecursiveAction extends RecursiveAction{

	private static final long serialVersionUID = -4607915544353175262L;

	@Override
	protected void compute() {
		System.out.println("compute run!");
	}

}
