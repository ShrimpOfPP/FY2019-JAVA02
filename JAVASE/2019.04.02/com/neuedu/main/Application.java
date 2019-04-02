package com.neuedu.main;

import java.util.Random;
import java.util.Scanner;

import com.neuedu.pojo.Administor;
import com.neuedu.server.UserBiz;
import com.neuedu.server.ImpL.UserBizImpL;
import com.neuedu.view.UserView;
import com.neuedu.view.ImpL.UserViewImpL;



public class Application {
	
	//操作选择
	public static void Choose(Administor admin){
		System.out.println("-----------------欢迎登陆学生信息管理系统---------------");
		System.out.println("1.登录                    2.退出");
		System.out.println("------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("请选择");
			int i = scanner.nextInt();
			if(i==1){
				IdentityChecked(admin);
				break;
			}else if(i==2){
				System.out.println("您已退出");
				break;
			}
		}
	}
	
	public static void IdentityChecked(Administor admin){
		Scanner scanner = new Scanner(System.in);
		//Scanner scanner2 = new Scanner(System.in);
		String charnum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		
		char Yanzhengma [] = new char[4];
		char a;
		for(int i = 0;i < 4;i++){
			int n = random.nextInt(charnum.length());
			a = charnum.charAt(n);
			Yanzhengma[i] = a;
		}
		
		String Verification = new String(Yanzhengma);
		
		UserView userView = new UserViewImpL();
		//userView.UserBizInit();
	//	userView.UserBizInit1();//初始化学生集合,按成绩从小到大
		//UserBizImpL userBizImpL = UserBizImpL.getInstance();
		
		System.out.print("请输入用户名：");
		String username = scanner.nextLine();
	
		System.out.print("请输入密码：");
		String password = scanner.nextLine();
		
		System.out.println("验证码为：" + Verification);
		System.out.println("请输入验证码：");
		String AboutVerificated = scanner.nextLine(); 
		
		if(username.equalsIgnoreCase(admin.username) && password.equals(admin.password) && AboutVerificated.equalsIgnoreCase(Verification)){
			System.out.println("登陆成功！");
			System.out.println("欢迎您" + admin.username);
			userView.StudentControl();//操作学生信息
		}else{
			System.out.println("用户名或密码或验证码错误!");
		}	
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "admin";
		String password = "admin";
	
		Administor admin = new Administor(username,password);
		
		Choose(admin);//登录操做选择
	}

}
