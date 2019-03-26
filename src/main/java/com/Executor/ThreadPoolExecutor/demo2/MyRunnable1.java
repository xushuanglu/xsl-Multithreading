package com.Executor.ThreadPoolExecutor.demo2;

public class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				Math.random();
				Math.random();
				Math.random();
				Math.random();
				Math.random();
				Math.random();
				if (Thread.currentThread().isInterrupted() == true) {
					System.out.println("任务没有完成，就中断了！");
					exceptionMsg();
				}
			}
			System.out.println("任务成功完成！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 异常信息
	 * @throws InterruptedException
	 */
	public void exceptionMsg() throws InterruptedException {
		throw new InterruptedException();
	}

}
