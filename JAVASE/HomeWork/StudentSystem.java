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
	
	public void SetId(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入ID");
		int id = scanner.nextInt();
		this.id = id;

	}
	
	public void GetId(){
		System.out.println("该学生的ID：" + this.id);
	}
	
	public void SetName(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名");
		String name = scanner.next();
		this.name = name;
		
	}
	
	public void GetName(){
		System.out.println("该学生的名字是：" + this.name);
	}
	
	public void SetSex(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入性别");
		String sex = scanner.next();
		this.sex = sex;
		
	}
	
	public void GetSex(){
		System.out.println("该学生的性别是：" + this.sex);
	}
	
	public void SetAge(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年龄");
		int age = scanner.nextInt();
		this.age = age;
		
	}
	
	public void GetAge(){
		System.out.println("该学生的年龄是：" + this.age);
	}
	
	public void AddStudent(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入学生ID：");
		int id = scanner.nextInt();
		this.id = id;
		System.out.print("请输入学生名字：");
		String name = scanner.next();
		this.name = name;
		System.out.print("请输入学生性别：");
		String sex = scanner.next();
		this.sex = sex;
		System.out.print("请输入学生年龄：");
		int age = scanner.nextInt();
		this.age = age;
		
	}
	
	public void ShowStudent(){
		System.out.println("*******************");
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
				System.out.println("欢迎登陆");
				/*scanner.close();*/
				break;
			}else if(i==2){
				System.out.println("您已退出");
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
		
		if(username.equals(admin.username) && password.equals(admin.password)){
			System.out.println("登陆成功！");
			System.out.println("欢迎您" + admin.username);
			ControlStudent(student);//操作学生信息
			
		}else{
			System.out.println("用户名或密码错误!");
		}	
		
		
	}
	
	//操作学生信息
	public static void ControlStudent(Student[] student){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("****************请选择要操作的信息对应数字*********************************");
			System.out.println("*1.查看学生信息            2.添加学生信息                  3.删除学生信息                 4.修改学生信息              5.退出");
			System.out.println("******************************************************************");
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
				System.out.println("请输入要添加的学生ID");
				int id = scanner.nextInt();
				for(int i=0;i<student.length;i++){
					if(id!=student[i].id && i==student.length-1){
						System.out.println("****************添加学生信息*****************************");
						Student t = new Student(0,"0","0",0);
						//t.AddStudent();//添加学生个人信息
						t.id = id;
						t.SetName();
						t.SetSex();
						t.SetAge();
						
						Student[] stu = new Student[student.length+1];
						System.arraycopy(student, 0, stu, 0, student.length);
						stu[student.length] = t;
						student = stu;//将更改的数组地址赋予原来的数组
						for(i = 0;i < student.length;i++){
							student[i].ShowStudent();
						}
					}else if(id==student[i].id){
						System.out.println("ID已存在，请重新输入");
						break;
					}
				}
				
			}
			if(function==3){
				System.out.println("****************删除学生信息************************");
				Student[] stu = new Student[student.length-1];//保存更新后的学生信息
				System.out.print("请输入需要删除的学生ID：");
				int id = scanner.nextInt();
				for(int i = 0;i < student.length;i++){
					if(student[i].id == id){
						if(i==0){
							System.arraycopy(student, i+1, stu, 0, student.length-1);
						}else if(i==student.length-1){
							System.arraycopy(student, 0, stu, 0, student.length-1);
						}else{
							System.arraycopy(student, 0, stu, 0, i);
							System.arraycopy(student, i+1, stu, i, student.length-1-i);
						}
						student = stu;//更新原数组
						System.out.print("删除成功！");
						for(int j = 0;j < student.length;j++){
							student[j].ShowStudent();
						}
						break;
					}
					if(i==student.length-1 && id!=student[i].id){
						System.out.println("没有该id");
					}
				}
			}
			if(function==4){
				System.out.println("****************修改学生信息************************");
				while(true){
				
				System.out.print("请输入需要修改的学生信息的ID：");
				int id = scanner.nextInt();
				for(int i = 0;i < student.length;i++){
					if(student[i].id==id){
							System.out.println("1.修改ID 2.修改名字  3.修改性别   4.修改年龄  5.全部修改 ");
							System.out.print("请输入需要操作的数字:");
							int num = scanner.nextInt();
							if(num==1){
								System.out.println("请输入新的ID");
								int id1 = scanner.nextInt();
								for(int k=0;k<student.length;k++){
									if(id1!=student[k].id && k==student.length-1){
										student[i].id = id1;
										break;
									}else if(id1==student[k].id){
										System.out.println("ID已存在，请重新输入");
										break;
									}
								}
								//student[i].SetId();
								student[i].GetId();
								break;
							}else if(num==2){
								student[i].SetName();
								student[i].GetName();
								break;
							}else if(num==3){
								student[i].SetSex();
								student[i].GetSex();
								break;
							}else if(num==4){
								student[i].SetAge();
								student[i].GetAge();
								break;
							}else if(num==5){
								student[i].SetId();
								student[i].GetId();
								student[i].SetName();
								student[i].GetName();
								student[i].SetSex();
								student[i].GetSex();
								student[i].SetAge();
								student[i].GetAge();
								break;
							}
						
					}
					if(i==student.length-1 && id!=student[i].id){
						System.out.println("没有该id");
						
					}
				}
				System.out.println("是否继续y/n:");
				String judge = scanner.next();
				if(judge.equals("n"))
					break;
			}
				
			}
			if(function==5){
				System.out.println("*******************退出**************************");
				break;
			}
		}
		
		scanner.close();
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
