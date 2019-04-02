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
		System.out.println("****************查看学生信息*****************************");
		System.out.print("请输入学生ID：");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentShow(id);
	}

	@Override
	public void StudentAdd() {
		// TODO Auto-generated method stub
		System.out.println("请输入要添加的学生ID");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentAdd(id);
	}

	@Override
	public void StudentDelete() {
		// TODO Auto-generated method stub
		System.out.println("****************删除学生信息************************");
		System.out.print("请输入需要删除的学生ID：");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentDelete(id);
	}

	@Override
	public void StudentModify() {
		// TODO Auto-generated method stub
		System.out.println("****************修改学生信息************************");
		System.out.print("请输入需要修改的学生信息的ID：");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		
		userBiz.StudentModify(id);
	}

	@Override
	public void DropOut() {
		// TODO Auto-generated method stub
		System.out.println("*******************退出**************************");
		
	}

	@Override
	public void StudentControl() {
		// TODO Auto-generated method stub
		
		while(true){
			Scanner scanner = new Scanner(System.in);
			System.out.println("****************请选择要操作的信息对应数字*********************************");
			System.out.println("*1.查看学生信息            2.添加学生信息                  3.删除学生信息                 4.修改学生信息              5.退出");
			System.out.println("******************************************************************");
			System.out.print("请选择：");
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
