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
		System.out.println("������ѧ��ID��");
		int id = scanner.nextInt();
		this.id = id;
		System.out.println("������ѧ�����֣�");
		String name = scanner.nextLine();
		this.name = name;
		System.out.println("������ѧ���Ա�");
		String sex = scanner.nextLine();
		this.sex = sex;
		System.out.println("������ѧ�����䣺");
		int age = scanner.nextInt();
		this.age = age;
	}
	
	public void ShowStudent(){
		System.out.println("ѧ��ID��" + this.id);
		System.out.println("ѧ��������" + this.name);
		System.out.println("ѧ���Ա�" + this.sex);
		System.out.println("ѧ�����䣺" + this.age);
	}
}

public class StudentSystem {
    //��¼
	public static void login(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("��ѡ��");
			int i = scanner.nextInt();
			if(i==1){
				System.out.print("��ӭ��½");
				/*scanner.close();*/
				break;
			}else if(i==2){
				System.out.print("�����˳�");
				/*scanner.close();*/
				break;
			}
		}
	}
	//�����֤
	public static void IdentityChecked(Administrator admin,Student[] student){
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.print("�������û�����");
		String username = scanner1.nextLine();
	
		System.out.print("���������룺");
		String password = scanner2.nextLine();
		/*scanner1.close();
		scanner2.close();*/
		
		if(username.equals(admin.username) && password.equals(admin.password)){
			System.out.println("��½�ɹ���");
			System.out.println("��ӭ��" + admin.username);
			ControlStudent(student);//����ѧ����Ϣ
			
		}else{
			System.out.println("�û������������!");
		}	
	}
	//��ѧ��������б�������
	public static void FindStudentId(Student[] student){
		
	}
	
	
	//����ѧ����Ϣ
	public static void ControlStudent(Student[] student){
		Scanner scanner = new Scanner(System.in);
		System.out.println("****************��ѡ��Ҫ��������Ϣ��Ӧ����*********************************");
		System.out.println("*1.�鿴ѧ����Ϣ            2.���ѧ����Ϣ                  3.ɾ��ѧ����Ϣ                 4.�޸�ѧ����Ϣ              5.�˳�");
		System.out.println("****************��ѡ��Ҫ��������Ϣ��Ӧ����*********************************");
		
		System.out.print("��ѡ��");
		int function = scanner.nextInt();
		if(function==1){
			System.out.println("****************�鿴ѧ����Ϣ*****************************");
			System.out.print("������ѧ��ID��");
			int id = scanner.nextInt();
			for(int i = 0;i<student.length;i++){
				if(id==student[i].id){
					student[i].ShowStudent();
					break;
				}
				if(i==student.length-1 && id!=student[i].id){
					System.out.println("û�и�id");
				}
			}
		}
		if(function==2){
			System.out.println("****************���ѧ����Ϣ*****************************");
			Student t = new Student(0,"0","0",0);
			t.AddStudent();//���ѧ��������Ϣ
			Student[] stu = new Student[student.length+1];
			System.arraycopy(student, 0, stu, 0, student.length);
			stu[student.length] = t;
			student = stu;//�����ĵ������ַ����ԭ��������
			for(int i = 0;i < student.length;i++){
				student[i].ShowStudent();
			}
		}
		if(function==3){
			System.out.println("****************ɾ��ѧ����Ϣ************************");
			
		}
		if(function==4){
			System.out.println("****************�޸�ѧ����Ϣ************************");
			
		}
		if(function==5){
			System.out.println("*******************�˳�**************************");
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------��ӭ��½ѧ����Ϣ����ϵͳ---------------");
		System.out.println("1.��¼                    2.�˳�");
		System.out.println("------------------------------------------------");
		
		String username = "admin";
		String password = "admin";
		
		Administrator a = new Administrator(username,password);
		
		Student t1 = new Student(1,"����","��",14) ;
		Student t2 = new Student(2,"����","Ů",18) ;
		Student t3 = new Student(3,"����","��",20) ;
		

		Student student[] = {t1,t2,t3};
		login();//��¼
		IdentityChecked(a,student);//��֤���
		
		
	}

}
