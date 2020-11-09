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
			System.out.println("== �Խù� ����Ʈ ==");
			System.out.printf("��ȣ / ����");

		}

	}

	private void articleAdd(String cmd) {
		if (session.isLogined() == false) {
			System.out.println("�α��� �� �̿����ּ���.");
			return;
		}
		System.out.println("== �Խù� ��� ==");
		System.out.printf("���� : ");
		String title = sc.nextLine();
		System.out.printf("���� : ");
		String body = sc.nextLine();

		int articleId = articleAdd(title, body);
		System.out.printf("%d�� �Խù��� �����Ǿ����ϴ�.%n", articleId);

	}

	private int articleAdd(String title, String body) {
		return articleService.articleAdd(title, body);

	}

}
