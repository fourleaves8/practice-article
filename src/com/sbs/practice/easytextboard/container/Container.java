package com.sbs.practice.easytextboard.container;

import java.util.Scanner;

import com.sbs.practice.easytextboard.dao.ArticleDao;
import com.sbs.practice.easytextboard.dao.UserDao;
import com.sbs.practice.easytextboard.service.ArticleService;
import com.sbs.practice.easytextboard.service.UserService;

public class Container {

	public static Scanner sc;
	public static UserDao userDao;
	public static ArticleDao articleDao;
	public static UserService userService;
	public static ArticleService articleService;
	public static Session session;
	
	

	static {
		sc = new Scanner(System.in);
		
		userDao = new UserDao();
		articleDao = new ArticleDao();
		
		userService = new UserService();
		articleService = new ArticleService();
		
		session = new Session();

	}

}
