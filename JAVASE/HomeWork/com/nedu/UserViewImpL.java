package com.nedu;

import java.util.Scanner;

public class UserViewImpL implements UserView{

	UserBiz userBiz = new UserBizImpL();
	
	UserViewImpL(){
		
	}
	@Override
	public void login() {
		// TODO Auto-generated method stub
		System.out.println("���е�¼����");
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������û���");
		String username = scanner.nextLine();
		System.out.println("�������������");
		String password = scanner.nextLine();
	
		userBiz.login(username, password);
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		System.out.println("����ע���û�����");
		Scanner scanner = new Scanner(System.in);
		System.out.println("����ע���û�������");
		String username = scanner.nextLine();
		System.out.println("����ע���������");
		String password = scanner.nextLine();
		System.out.println("�����ٴ������������");
		String password2 = scanner.nextLine();
		System.out.println("������д��������");
		String name = scanner.nextLine();
		System.out.println("������д�������");
		String email = scanner.nextLine();
		
		userBiz.register(username, password, password2, name, email);
	}

}
