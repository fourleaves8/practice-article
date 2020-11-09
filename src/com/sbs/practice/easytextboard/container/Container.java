package com.sbs.practice.easytextboard.container;

import java.util.Scanner;

import com.sbs.practice.easytextboard.dao.UserDao;
import com.sbs.practice.easytextboard.service.UserService;

public class Container {

	public static Scanner sc;
	public static UserDao userDao;
	public static UserService userService;
	public static Session session;

	static {
		sc = new Scanner(System.in);
		userDao = new UserDao();
		userService = new UserService();
		session = new Session();

	}

}
