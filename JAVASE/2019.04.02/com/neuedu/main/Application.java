package com.neuedu.main;

import java.util.Random;
import java.util.Scanner;

import com.neuedu.pojo.Administor;
import com.neuedu.server.UserBiz;
import com.neuedu.server.ImpL.UserBizImpL;
import com.neuedu.view.UserView;
import com.neuedu.view.ImpL.UserViewImpL;



public class Application {
	
	//����ѡ��
	public static void Choose(Administor admin){
		System.out.println("-----------------��ӭ��½ѧ����Ϣ����ϵͳ---------------");
		System.out.println("1.��¼                    2.�˳�");
		System.out.println("------------------------------------------------");
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("��ѡ��");
			int i = scanner.nextInt();
			if(i==1){
				IdentityChecked(admin);
				break;
			}else if(i==2){
				System.out.println("�����˳�");
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
	//	userView.UserBizInit1();//��ʼ��ѧ������,���ɼ���С����
		//UserBizImpL userBizImpL = UserBizImpL.getInstance();
		
		System.out.print("�������û�����");
		String username = scanner.nextLine();
	
		System.out.print("���������룺");
		String password = scanner.nextLine();
		
		System.out.println("��֤��Ϊ��" + Verification);
		System.out.println("��������֤�룺");
		String AboutVerificated = scanner.nextLine(); 
		
		if(username.equalsIgnoreCase(admin.username) && password.equals(admin.password) && AboutVerificated.equalsIgnoreCase(Verification)){
			System.out.println("��½�ɹ���");
			System.out.println("��ӭ��" + admin.username);
			userView.StudentControl();//����ѧ����Ϣ
		}else{
			System.out.println("�û������������֤�����!");
		}	
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "admin";
		String password = "admin";
	
		Administor admin = new Administor(username,password);
		
		Choose(admin);//��¼����ѡ��
	}

}
