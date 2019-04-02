package com.neuedu.view.ImpL;

import java.util.Scanner;

import com.neuedu.pojo.Student;
import com.neuedu.server.UserBiz;
import com.neuedu.server.ImpL.UserBizImpL;
import com.neuedu.view.UserView;



public class UserViewImpL implements UserView{

	//UserBiz userBiz = new UserBizImpL();
	UserBiz userBiz = UserBizImpL.getInstance();
	
	@Override
	public void StudentShow() {
		// TODO Auto-generated method stub
		System.out.println("****************�鿴ѧ����Ϣ*****************************");
		System.out.print("������ѧ��ID��");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentShow(id);
	}

	@Override
	public void StudentAdd() {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ��ӵ�ѧ��ID");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentAdd(id);
	}

	@Override
	public void StudentDelete() {
		// TODO Auto-generated method stub
		System.out.println("****************ɾ��ѧ����Ϣ************************");
		System.out.print("��������Ҫɾ����ѧ��ID��");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentDelete(id);
	}

	@Override
	public void StudentModify() {
		// TODO Auto-generated method stub
		System.out.println("****************�޸�ѧ����Ϣ************************");
		System.out.print("��������Ҫ�޸ĵ�ѧ����Ϣ��ID��");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentModify(id);
	}

	@Override
	public void DropOut() {
		// TODO Auto-generated method stub
		System.out.println("*******************�˳�**************************");
		
	}

	@Override
	public void StudentControl() {
		// TODO Auto-generated method stub
		
		while(true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("****************��ѡ��Ҫ��������Ϣ��Ӧ����*********************************");
			System.out.println("*1.�鿴ѧ����Ϣ            2.���ѧ����Ϣ                  3.ɾ��ѧ����Ϣ                 4.�޸�ѧ����Ϣ              5.�˳�");
			System.out.println("******************************************************************");
			System.out.print("��ѡ��");
			int function = scanner.nextInt();
			if(function==1){
				this.StudentShow();
			}
			
			if(function==2){
				this.StudentAdd();
			}
			
			if(function==3){
				this.StudentDelete();
			}
			
			if(function==4){	
				this.StudentModify();
			}
			
			if(function==5){
				this.DropOut();
				break;
			}
		}
		
	}

	@Override
	public void UserBizInit() {
		// TODO Auto-generated method stub
		this.userBiz.InitStudent();
	}

	@Override
	public void UserBizInit1() {
		// TODO Auto-generated method stub
		this.userBiz.InitStudentList();
	}

}
