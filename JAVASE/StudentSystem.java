package test;

import java.util.Scanner;

class Administrator {
	public String username;
	public String password;
	
	public Administrator(String username,String password){
		this.username = username;
		this.password = password;
	}
}

class Student {
	
	public int id;
	public String name;
	public String sex;
	public int age;
	
	public Student(int id,String name,String sex,int age){
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public void SetId(int id){
		this.id = id;
	}
	public void SetName(String name){
		this.name = name;
	}
	public void SetSex(String sex){
		this.sex = sex;
	}
	public void SetAge(int age){
		this.age = age;
	}
	
	public void AddStudent(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生ID：");
		int id = scanner.nextInt();
		this.id = id;
		System.out.println("请输入学生名字：");
		String name = scanner.nextLine();
		this.name = name;
		System.out.println("请输入学生性别：");
		String sex = scanner.nextLine();
		this.sex = sex;
		System.out.println("请输入学生年龄：");
		int age = scanner.nextInt();
		this.age = age;
	}
	
	public void ShowStudent(){
		System.out.println("学生ID：" + this.id);
		System.out.println("学生姓名：" + this.name);
		System.out.println("学生性别：" + this.sex);
		System.out.println("学生年龄：" + this.age);
	}
}

public class StudentSystem {
    //登录
	public static void login(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("请选择");
			int i = scanner.nextInt();
			if(i==1){
				System.out.print("欢迎登陆");
				/*scanner.close();*/
				break;
			}else if(i==2){
				System.out.print("您已退出");
				/*scanner.close();*/
				break;
			}
		}
	}
	//身份验证
	public static void IdentityChecked(Administrator admin,Student[] student){
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.print("请输入用户名：");
		String username = scanner1.nextLine();
	
		System.out.print("请输入密码：");
		String password = scanner2.nextLine();
		/*scanner1.close();
		scanner2.close();*/
		
		if(username.equals(admin.username) && password.equals(admin.password)){
			System.out.println("登陆成功！");
			System.out.println("欢迎您" + admin.username);
			ControlStudent(student);//操作学生信息
			
		}else{
			System.out.println("用户名或密码错误!");
		}	
	}
	//对学生数组进行遍历操作
	public static void FindStudentId(Student[] student){
		
	}
	
	
	//操作学生信息
	public static void ControlStudent(Student[] student){
		Scanner scanner = new Scanner(System.in);
		System.out.println("****************请选择要操作的信息对应数字*********************************");
		System.out.println("*1.查看学生信息            2.添加学生信息                  3.删除学生信息                 4.修改学生信息              5.退出");
		System.out.println("****************请选择要操作的信息对应数字*********************************");
		
		System.out.print("请选择：");
		int function = scanner.nextInt();
		if(function==1){
			System.out.println("****************查看学生信息*****************************");
			System.out.print("请输入学生ID：");
			int id = scanner.nextInt();
			for(int i = 0;i<student.length;i++){
				if(id==student[i].id){
					student[i].ShowStudent();
					break;
				}
				if(i==student.length-1 && id!=student[i].id){
					System.out.println("没有该id");
				}
			}
		}
		if(function==2){
			System.out.println("****************添加学生信息*****************************");
			Student t = new Student(0,"0","0",0);
			t.AddStudent();//添加学生个人信息
			Student[] stu = new Student[student.length+1];
			System.arraycopy(student, 0, stu, 0, student.length);
			stu[student.length] = t;
			student = stu;//将更改的数组地址赋予原来的数组
			for(int i = 0;i < student.length;i++){
				student[i].ShowStudent();
			}
		}
		if(function==3){
			System.out.println("****************删除学生信息************************");
			
		}
		if(function==4){
			System.out.println("****************修改学生信息************************");
			
		}
		if(function==5){
			System.out.println("*******************退出**************************");
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------欢迎登陆学生信息管理系统---------------");
		System.out.println("1.登录                    2.退出");
		System.out.println("------------------------------------------------");
		
		String username = "admin";
		String password = "admin";
		
		Administrator a = new Administrator(username,password);
		
		Student t1 = new Student(1,"张三","男",14) ;
		Student t2 = new Student(2,"李四","女",18) ;
		Student t3 = new Student(3,"王五","男",20) ;
		

		Student student[] = {t1,t2,t3};
		login();//登录
		IdentityChecked(a,student);//验证身份
		
		
	}

}
