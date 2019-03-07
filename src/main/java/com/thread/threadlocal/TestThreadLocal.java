package com.thread.threadlocal;

public class TestThreadLocal {
	
	private static final ThreadLocal<String> threadLocalA = new ThreadLocal<>();
	private static final ThreadLocal<String> threadLocalB = new ThreadLocal<>();

	/**
	 * �ڵ��õ��̵߳�map�д���keyΪThreadLocal����valueΪ�ڸ��߳����õ�ֵ
	 * 
	 * @param value
	 */
	public static void setValueA(String value) {
		threadLocalA.set(value);
	}

	public static String getValueA() {
		return threadLocalA.get();
	}

	public static void clearValueA() {
		threadLocalA.remove();
	}

	public static void setValueB(String value) {
		threadLocalB.set(value);
	}

	public static String getValueB() {
		return threadLocalB.get();
	}

	public static void clearValueB() {
		threadLocalB.remove();
	}

	public static void main(String[] args) {
		// �߳�1��ThreadLocalMap�д���keyΪthreadLocalA��valueΪA1��keyΪthreadLocalB��valueΪB1
		new Thread() {
			@Override
			public void run() {
				setValueA("A1");
				System.out.println("thread1:" + getValueA());
				clearValueA();

				setValueB("B1");
				System.out.println("thread1:" + getValueB());
				clearValueB();
			}
		}.start();

		// �߳�2��ThreadLocalMap�д���keyΪthreadLocalA��valueΪA2��keyΪthreadLocalB��valueΪB2
		new Thread() {
			@Override
			public void run() {
				setValueA("A2");
				System.out.println("thread2:" + getValueA());
				clearValueA();

				setValueB("B2");
				System.out.println("thread2:" + getValueB());
				clearValueB();
			}
		}.start();
	}
}
