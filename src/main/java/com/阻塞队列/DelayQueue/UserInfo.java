package com.×èÈû¶ÓÁÐ.DelayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class UserInfo implements Delayed{
	
	private long delayNanoTime;//ÑÓ³ÙµÄÄÉÃë
	private String username;
	
	public UserInfo(long delayTime,String username) {
		super();
		this.username = username;
		
		TimeUnit unit = TimeUnit.SECONDS;
		delayNanoTime = System.nanoTime() + unit.toNanos(delayTime);
	}

	@Override
	public int compareTo(Delayed o) {
		if((this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS)) < 0){
			return -1;
		}
		if((this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS)) > 0){
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(delayNanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
	}

	public long getDelayNanoTime() {
		return delayNanoTime;
	}

	public void setDelayNanoTime(long delayNanoTime) {
		this.delayNanoTime = delayNanoTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
