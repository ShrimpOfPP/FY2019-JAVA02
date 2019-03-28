package com.nedu;

import java.util.Scanner;

public class UserViewImpL implements UserView{

	UserBiz userBiz = new UserBizImpL();
	
	UserViewImpL(){
		
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("进行登录操作");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的用户名");
		String username = scanner.nextLine();
		System.out.println("请输入你的密码");
		String password = scanner.nextLine();
	
		userBiz.login(username, password);
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		System.out.println("进行注册用户操作");
		Scanner scanner = new Scanner(System.in);
		System.out.println("进行注册用户名操作");
		String username = scanner.nextLine();
		System.out.println("进行注册密码操作");
		String password = scanner.nextLine();
		System.out.println("进行再次输入密码操作");
		String password2 = scanner.nextLine();
		System.out.println("进行填写姓名操作");
		String name = scanner.nextLine();
		System.out.println("进行填写邮箱操作");
		String email = scanner.nextLine();
		
		userBiz.register(username, password, password2, name, email);
	}

}
