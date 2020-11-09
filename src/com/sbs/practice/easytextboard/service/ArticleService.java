package com.sbs.practice.easytextboard.service;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.dao.ArticleDao;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService () {
		articleDao = Container.articleDao;
	}

	public int articleAdd(String title, String body) {
		return articleDao.add(title, body);
	}

}
