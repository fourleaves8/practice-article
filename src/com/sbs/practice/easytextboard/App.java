package com.sbs.practice.easytextboard;

import java.util.Scanner;

import com.sbs.practice.easytextboard.container.Container;
import com.sbs.practice.easytextboard.controller.UserController;

public class App {

	private UserController userController = new UserController();

	public void run() {
		Scanner sc = Container.sc;

		while (true) {
			System.out.print("명령어) ");
			String cmd = sc.nextLine();

			if (cmd.equals("system exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (cmd.startsWith("user ")) {
				userController.doCmd(cmd);
			}

		}

	}

}
