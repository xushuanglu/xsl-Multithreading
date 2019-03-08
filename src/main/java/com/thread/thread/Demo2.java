package com.thread.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * java定时器使用
 * @author Administrator
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("timertask is run");
			}

		}, 0, 1000);
	}
}
