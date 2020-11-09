package com.sbs.practice.easytextboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.practice.easytextboard.dto.Article;

public class ArticleDao {
	private List<Article> articles;
	private int lastArticleId;

	public ArticleDao() {
		articles = new ArrayList<>();
		lastArticleId = 0;
	}

	public int add(int userId, String title, String body) {
		Article article = new Article();
		article.articleId = lastArticleId + 1;
		article.title = title;
		article.body = body;
		article.userId = userId;
		articles.add(article);

		lastArticleId = article.articleId;

		return article.articleId;

	}

	public List<Article> getAllArticles() {
		return articles;
	}

}
