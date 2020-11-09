package com.sbs.practice.easytextboard.service;

import java.util.List;
import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.dao.ArticleDao;
import com.sbs.practice.easytextboard.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = Container.articleDao;
	}

	public int articleAdd(int userId, String title, String body) {
		return articleDao.add(userId, title, body);
	}

	public List<Article> getAllArticles() {
		return articleDao.getAllArticles();
	}

}
