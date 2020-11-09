package com.sbs.practice.easytextboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.practice.easytextboard.dto.User;

public class UserDao {
	private List<User> users;
	private int lastUserId;

	public UserDao() {
		users = new ArrayList<>();
		lastUserId = 0;
	}

	public int add(String accountName, String accountPw, String name) {
		User user = new User();
		user.userId = lastUserId + 1;
		user.accountName = accountName;
		user.accountPw = accountPw;
		user.name = name;
		users.add(user);

		lastUserId = user.userId;

		return user.userId;

	}

	public User getValidAccountName(String accountName) {
		for (User user : users) {
			if (user.accountName.equals(accountName)) {
				return user;
			}
		}
		return null;
	}

}
