package com.sbs.practice.easytextboard.controller;

import java.util.Scanner;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.container.Session;
import com.sbs.practice.easytextboard.dto.User;
import com.sbs.practice.easytextboard.service.UserService;

public class UserController {
	private Scanner sc;
	private UserService userService;
	private Session session;

	public UserController() {
		sc = Container.sc;
		userService = Container.userService;
		session = Container.session;
	}

	public void doCmd(String cmd) {

		if (cmd.equals("user join")) {
			join(cmd);
		} else if (cmd.equals("user login")) {
			login(cmd);
		} else if (cmd.equals("user logout")) {
			logout(cmd);
		}

	}

	private void logout(String cmd) {
		if (session.isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
		session.logout();
		System.out.println("로그아웃 되었습니다.");

	}

	private void login(String cmd) {
		System.out.println("== 회원 로그인 ==");
		String accountName;
		String accountPw;
		int maxFailCount = 3;
		int failCount = 0;

		while (true) {
			if (session.isLogined() == true) {
				System.out.println("이미 로그인 되어있습니다.");
				return;
			}
			if (failCount >= maxFailCount) {
				System.out.println("로그인을 취소합니다.");
				return;
			}

			System.out.printf("아이디 : ");
			accountName = sc.nextLine().trim();
			User user = userService.getUserByAccNm(accountName);

			if (accountName.length() == 0) {
				System.out.printf("올바른 아이디를 입력하세요.%n", accountName);
				failCount++;
				continue;
			} else if (user == null) {
				System.out.printf("%s(은)는 존재하지 않는 아이디 입니다.%n", accountName);
				failCount++;
				continue;
			} else if (user != null) {
				failCount = 0;
				while (true) {
					if (failCount >= maxFailCount) {
						System.out.println("회원가입을 취소합니다.");
						return;
					}

					System.out.printf("비밀번호 : ");
					accountPw = sc.nextLine().trim();

					if (accountPw.length() == 0) {
						System.out.println("올바른 비밀번호를 입력하세요.");
						failCount++;
						continue;
					} else if (accountPw.equals(user.accountPw) == false) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						failCount++;
						continue;
					}
					session.login(user.userId);
					break;
				}
				break;
			}

		}

		System.out.printf("로그인 성공! %s님 환영합니다!%n", accountName);
	}

	private void join(String cmd) {
		System.out.println("== 회원 가입 ==");
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

			boolean isValidAccNm = userService.isValidAccNm(accountName);
			if (isValidAccNm == false) {
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
