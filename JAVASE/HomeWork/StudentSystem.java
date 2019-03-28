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
		System.out.println("������ID");
		int id = scanner.nextInt();
		this.id = id;

	}
	
	public void GetId(){
		System.out.println("��ѧ����ID��" + this.id);
	}
	
	public void SetName(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������");
		String name = scanner.next();
		this.name = name;
		
	}
	
	public void GetName(){
		System.out.println("��ѧ���������ǣ�" + this.name);
	}
	
	public void SetSex(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������Ա�");
		String sex = scanner.next();
		this.sex = sex;
		
	}
	
	public void GetSex(){
		System.out.println("��ѧ�����Ա��ǣ�" + this.sex);
	}
	
	public void SetAge(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������");
		int age = scanner.nextInt();
		this.age = age;
		
	}
	
	public void GetAge(){
		System.out.println("��ѧ���������ǣ�" + this.age);
	}
	
	public void AddStudent(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ѧ��ID��");
		int id = scanner.nextInt();
		this.id = id;
		System.out.print("������ѧ�����֣�");
		String name = scanner.next();
		this.name = name;
		System.out.print("������ѧ���Ա�");
		String sex = scanner.next();
		this.sex = sex;
		System.out.print("������ѧ�����䣺");
		int age = scanner.nextInt();
		this.age = age;
		
	}
	
	public void ShowStudent(){
		System.out.println("*******************");
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
				System.out.println("��ӭ��½");
				/*scanner.close();*/
				break;
			}else if(i==2){
				System.out.println("�����˳�");
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
		
		if(username.equals(admin.username) && password.equals(admin.password)){
			System.out.println("��½�ɹ���");
			System.out.println("��ӭ��" + admin.username);
			ControlStudent(student);//����ѧ����Ϣ
			
		}else{
			System.out.println("�û������������!");
		}	
		
		
	}
	
	//����ѧ����Ϣ
	public static void ControlStudent(Student[] student){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("****************��ѡ��Ҫ��������Ϣ��Ӧ����*********************************");
			System.out.println("*1.�鿴ѧ����Ϣ            2.���ѧ����Ϣ                  3.ɾ��ѧ����Ϣ                 4.�޸�ѧ����Ϣ              5.�˳�");
			System.out.println("******************************************************************");
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
				System.out.println("������Ҫ��ӵ�ѧ��ID");
				int id = scanner.nextInt();
				for(int i=0;i<student.length;i++){
					if(id!=student[i].id && i==student.length-1){
						System.out.println("****************���ѧ����Ϣ*****************************");
						Student t = new Student(0,"0","0",0);
						//t.AddStudent();//���ѧ��������Ϣ
						t.id = id;
						t.SetName();
						t.SetSex();
						t.SetAge();
						
						Student[] stu = new Student[student.length+1];
						System.arraycopy(student, 0, stu, 0, student.length);
						stu[student.length] = t;
						student = stu;//�����ĵ������ַ����ԭ��������
						for(i = 0;i < student.length;i++){
							student[i].ShowStudent();
						}
					}else if(id==student[i].id){
						System.out.println("ID�Ѵ��ڣ�����������");
						break;
					}
				}
				
			}
			if(function==3){
				System.out.println("****************ɾ��ѧ����Ϣ************************");
				Student[] stu = new Student[student.length-1];//������º��ѧ����Ϣ
				System.out.print("��������Ҫɾ����ѧ��ID��");
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
						student = stu;//����ԭ����
						System.out.print("ɾ���ɹ���");
						for(int j = 0;j < student.length;j++){
							student[j].ShowStudent();
						}
						break;
					}
					if(i==student.length-1 && id!=student[i].id){
						System.out.println("û�и�id");
					}
				}
			}
			if(function==4){
				System.out.println("****************�޸�ѧ����Ϣ************************");
				while(true){
				
				System.out.print("��������Ҫ�޸ĵ�ѧ����Ϣ��ID��");
				int id = scanner.nextInt();
				for(int i = 0;i < student.length;i++){
					if(student[i].id==id){
							System.out.println("1.�޸�ID 2.�޸�����  3.�޸��Ա�   4.�޸�����  5.ȫ���޸� ");
							System.out.print("��������Ҫ����������:");
							int num = scanner.nextInt();
							if(num==1){
								System.out.println("�������µ�ID");
								int id1 = scanner.nextInt();
								for(int k=0;k<student.length;k++){
									if(id1!=student[k].id && k==student.length-1){
										student[i].id = id1;
										break;
									}else if(id1==student[k].id){
										System.out.println("ID�Ѵ��ڣ�����������");
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
						System.out.println("û�и�id");
						
					}
				}
				System.out.println("�Ƿ����y/n:");
				String judge = scanner.next();
				if(judge.equals("n"))
					break;
			}
				
			}
			if(function==5){
				System.out.println("*******************�˳�**************************");
				break;
			}
		}
		
		scanner.close();
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
