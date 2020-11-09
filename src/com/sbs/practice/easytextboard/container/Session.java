package com.sbs.practice.easytextboard.container;

public class Session {
	public int loginedUserId;

	public boolean isLogined() {
		return loginedUserId > 0;
	}

	public Session() {
		loginedUserId = 0;
	}

	public void login(int userId) {
		loginedUserId = userId;

	}

	public void logout() {
		loginedUserId = 0;

	}

}
