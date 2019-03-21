package com.·Ç×èÈû¶ÓÁÐ.ConcurrentSkipListSet;

import java.util.concurrent.ConcurrentSkipListSet;

public class MyService1 {
 
	public ConcurrentSkipListSet map =new ConcurrentSkipListSet();
	
	public MyService1() {
		UserInfo userInfo1 = new UserInfo(1, "username1");
		UserInfo userInfo3 = new UserInfo(3, "username3");
		UserInfo userInfo5 = new UserInfo(5, "username5");
		UserInfo userInfo4 = new UserInfo(4, "username4");
		UserInfo userInfo44 = new UserInfo(4, "username4");
		UserInfo userInfo2 = new UserInfo(2, "username2");
		
		map.add(userInfo1);
		map.add(userInfo3);
		map.add(userInfo5);
		map.add(userInfo4);
		map.add(userInfo44);
		map.add(userInfo2);
	}
	
}
