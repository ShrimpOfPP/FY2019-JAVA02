package com.nedu;

import java.util.Scanner;

public class UserViewImpL implements UserView{

	UserBiz userBiz;
	
	@Override
	public void login() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		String password = scanner.nextLine();
		userBiz.login(username, password);
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		String password = scanner.nextLine();
		String password2 = scanner.nextLine();
		String name = scanner.nextLine();
		String email = scanner.nextLine();
		userBiz.register(username, password, password2, name, email);
	}

}
