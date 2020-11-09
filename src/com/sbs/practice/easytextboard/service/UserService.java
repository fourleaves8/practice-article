package com.sbs.practice.easytextboard.service;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.dao.UserDao;
import com.sbs.practice.easytextboard.dto.User;

public class UserService {

	private UserDao userDao;
	
	public UserService () {
		userDao = Container.userDao;
		
	}

	public int join(String accountName, String accountPw, String name) {
		return userDao.add(accountName, accountPw, name);
		
	}

	public boolean isValidAccountName(String accountName) {
		User user = userDao.getValidAccountName(accountName);
		if (user != null) {
			return false;
		}
		return true;
	}

}
