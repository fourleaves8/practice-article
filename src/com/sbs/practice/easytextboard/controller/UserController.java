package com.sbs.practice.easytextboard.controller;

import java.util.Scanner;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.service.UserService;

public class UserController {
	private Scanner sc;
	private UserService userService;

	public UserController() {
		sc = Container.sc;
		userService = Container.userService;
	}

	public void doCmd(String cmd) {

		if (cmd.equals("user join")) {
			join(cmd);
		}

	}

	private void join(String cmd) {
		System.out.println("== 회원가입 ==");
		String accountName;
		String accountPw;
		String name;
		int maxFailCount = 3;
		int failCount = 0;

		while (true) {

			if (failCount >= maxFailCount) {
				System.out.println("회원가입을 취소합니다.");
				return;
			}

			System.out.printf("사용하실 아이디 : ");
			accountName = sc.nextLine().trim();

			boolean isValidAccountName = userService.isValidAccountName(accountName);
			if (isValidAccountName == false) {
				System.out.printf("%s는 이미 사용중인 아이디 입니다.%n", accountName);
				failCount++;
				continue;
			} else if (accountName.length() == 0) {
				System.out.println("올바른 아이디를 입력하세요.");
				failCount++;
				continue;
			}
			failCount = 0;
			break;
		}

		while (true) {
			if (failCount >= maxFailCount) {
				System.out.println("회원가입을 취소합니다.");
				return;
			}

			System.out.printf("사용하실 비밀번호 : ");
			accountPw = sc.nextLine().trim();

			if (accountPw.length() == 0) {
				System.out.println("올바른 비밀번호를 입력하세요.");
				failCount++;
				continue;
			}
			failCount = 0;
			break;
		}

		while (true) {
			if (failCount >= maxFailCount) {
				System.out.println("회원가입을 취소합니다.");
				return;
			}

			System.out.printf("이름 : ");
			name = sc.nextLine().trim();

			if (name.length() == 0) {
				System.out.println("올바른 이름을 입력하세요.");
				failCount++;
				continue;
			}
			failCount = 0;
			break;
		}

		int userId = userService.join(accountName, accountPw, name);
		System.out.printf("%d번 회원이 생성되었습니다.%n", userId);
	}

}
