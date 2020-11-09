package com.sbs.practice.easytextboard.controller;

import java.util.List;
import java.util.Scanner;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.container.Session;
import com.sbs.practice.easytextboard.dto.Article;
import com.sbs.practice.easytextboard.dto.User;
import com.sbs.practice.easytextboard.service.ArticleService;
import com.sbs.practice.easytextboard.service.UserService;

public class ArticleController {
	private Scanner sc;
	private ArticleService articleService;
	private Session session;
	private UserService userService;

	public ArticleController() {
		sc = Container.sc;
		articleService = Container.articleService;
		session = Container.session;
		userService = Container.userService;
	}

	public void doCmd(String cmd) {
		if (cmd.equals("article add")) {
			articleAdd(cmd);

		} else if (cmd.equals("article list")) {
			articleList(cmd);
		}
	}

	private void articleList(String cmd) {
		System.out.println("== 게시물 리스트 ==");

		List<Article> articles = articleService.getAllArticles();

		System.out.println("번호 / 작성자 / 제목");
		for (Article article : articles) {
			System.out.printf("%d / %s / %s%n", article.articleId, article.userId, article.title);
		}
	}

	private void articleAdd(String cmd) {
		if (session.isLogined() == false) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		System.out.println("== 게시물 등록 ==");
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		int articleId = articleAdd(Container.session.loginedUserId, title, body);
		System.out.printf("%d번 게시물이 생성되었습니다.%n", articleId);

	}

	private int articleAdd(int userId, String title, String body) {
		return articleService.articleAdd(userId, title, body);

	}

}
