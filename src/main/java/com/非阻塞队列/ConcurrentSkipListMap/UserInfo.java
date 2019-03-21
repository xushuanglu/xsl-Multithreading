package com.·Ç×èÈû¶ÓÁĞ.ConcurrentSkipListMap;

public class UserInfo implements Comparable<UserInfo> {

	private int id;
	private String username;

	public UserInfo() {
		super();
	}

	public UserInfo(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
