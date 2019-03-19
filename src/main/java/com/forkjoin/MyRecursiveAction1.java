package com.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * 使用  RecursiveAction让任务跑起来
 * @author Administrator
 */
public class MyRecursiveAction1 extends RecursiveAction{

	private static final long serialVersionUID = -4607915544353175262L;
	
	private int beginValue;
	private int endValue;

	@Override
	protected void compute() {
		System.out.println(Thread.currentThread().getName() + "------------------");
		if(endValue - beginValue > 2) {
			int middelNum = (beginValue + endValue) / 2;
			MyRecursiveAction1 leftAction = new MyRecursiveAction1(beginValue,endValue);
			MyRecursiveAction1 rightAction = new MyRecursiveAction1(middelNum + 1,endValue);
			this.invokeAll(leftAction,rightAction);
		}else {
			System.out.println("打印组合为：" + beginValue + "-" + endValue);
		}
	}
	
	public MyRecursiveAction1(int beginValue,int endValue) {
		super();
		this.beginValue = beginValue;
		this.endValue = endValue;
	}

}
