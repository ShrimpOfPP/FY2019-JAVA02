package com.nedu;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserViewImpL userViewImpL = new UserViewImpL();
		userViewImpL.userBiz.GetUserArray();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("========1.登录功能       2.注册功能     3.退出操作=========");
			System.out.println("请选择你的操作");
			int control = scanner.nextInt();
			if(control==1){
				userViewImpL.login();
			}else if(control==2){
				userViewImpL.register();
			}else if(control==3){
				System.out.println("您已退出操作");
				break;
			}else{
				System.out.println("请输入正确的数字");
			}
		}
		
		/*for(int i = 0;i < userViewImpL.userBiz.user.length;i++){
		
			System.out.print("用户名:");
			userViewImpL.userBiz.user[i].GetUsername();
			System.out.print("密码:");
			userViewImpL.userBiz.user[i].GetPassWord();
			System.out.print("姓名:");
			userViewImpL.userBiz.user[i].GetName();
			System.out.print("邮箱:");
			userViewImpL.userBiz.user[i].GetEmail();
			System.out.println("==================");
		}*/
	}

}
