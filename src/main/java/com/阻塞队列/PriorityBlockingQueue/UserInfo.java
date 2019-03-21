package com.×èÈû¶ÓÁĞ.PriorityBlockingQueue;

public class UserInfo implements Comparable<UserInfo> {

	private int id;

	public UserInfo() {
		super();
	}

	public UserInfo(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(UserInfo o) {
		if (this.getId() < o.id) {
			return -1;
		}
		if (this.getId() > o.id) {
			return 1;
		}
		return 0;
	}

}
