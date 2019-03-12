package com.thread.ReenterLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentratReadWriteLockDemo {

	public static void main(String[] args) {
		News news = new News();
		// read
		for (int n = 0; n < 3; n++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					String pre = "";
					while (true) {
						String s = news.getLast();
						if (s == null)
							continue;
						if (!s.equals(pre)) {
							pre = s;
							System.out.println(Thread.currentThread().getName() + " get the last news : " + s);
							if (Integer.parseInt(s) == 9)
								break;
						}
					}
				}
			}, "read thread" + n).start();
		}

		// write
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					news.add(i + "");
				}
			}
		}).start();
	}

	static class News {

		private final List<String> newsList = new ArrayList<>();

		private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

		private Lock readLock = lock.readLock();

		private Lock writeLock = lock.writeLock();

		public String getLast() {
			readLock.lock();
			try {
				if (newsList.size() == 0)
					return null;
				return newsList.get(newsList.size() - 1);
			} finally {
				readLock.unlock();
			}
		}

		public void add(String news) {
			writeLock.lock();
			try {
				newsList.add(news);
				System.out.println("add a news:" + news);
			} finally {
				writeLock.unlock();
			}
		}
	}
}
