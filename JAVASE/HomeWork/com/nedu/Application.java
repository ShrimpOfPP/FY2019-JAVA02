package com.nedu;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserViewImpL userViewImpL = new UserViewImpL();
		userViewImpL.userBiz.GetUserArray();
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("========1.��¼����       2.ע�Ṧ��     3.�˳�����=========");
			System.out.println("��ѡ����Ĳ���");
			int control = scanner.nextInt();
			if(control==1){
				userViewImpL.login();
			}else if(control==2){
				userViewImpL.register();
			}else if(control==3){
				System.out.println("�����˳�����");
				break;
			}else{
				System.out.println("��������ȷ������");
			}
		}
		
		/*for(int i = 0;i < userViewImpL.userBiz.user.length;i++){
		
			System.out.print("�û���:");
			userViewImpL.userBiz.user[i].GetUsername();
			System.out.print("����:");
			userViewImpL.userBiz.user[i].GetPassWord();
			System.out.print("����:");
			userViewImpL.userBiz.user[i].GetName();
			System.out.print("����:");
			userViewImpL.userBiz.user[i].GetEmail();
			System.out.println("==================");
		}*/
	}

}
