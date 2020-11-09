package com.sbs.practice.easytextboard.controller;

import java.util.Scanner;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.container.Session;
import com.sbs.practice.easytextboard.service.ArticleService;

public class ArticleController {
	private Scanner sc;
	private ArticleService articleService;
	private Session session;

	public ArticleController() {
		sc = Container.sc;
		articleService = Container.articleService;
		session = Container.session;
	}

	public void doCmd(String cmd) {
		if (cmd.equals("article add")) {
			articleAdd(cmd);
		}

		else if (cmd.equals("article list")) {
			System.out.println("== 게시물 리스트 ==");
			System.out.printf("번호 / 제목");

		}

	}

	private void articleAdd(String cmd) {
		if (session.isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
		System.out.println("== 게시물 등록 ==");
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		int articleId = articleAdd(title, body);
		System.out.printf("%d번 게시물이 생성되었습니다.%n", articleId);

	}

	private int articleAdd(String title, String body) {
		return articleService.articleAdd(title, body);

	}

}
