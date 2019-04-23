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
					System.out.println("����û����ɣ����ж��ˣ�");
					exceptionMsg();
				}
			}
			System.out.println("����ɹ���ɣ�");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �쳣��Ϣ
	 * @throws InterruptedException
	 */
	public void exceptionMsg() throws InterruptedException {
		throw new InterruptedException();
	}

}
