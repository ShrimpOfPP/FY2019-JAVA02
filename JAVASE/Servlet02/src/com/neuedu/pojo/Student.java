package com.neuedu.pojo;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student>{

	public int id;
	public String name;
	public String sex;
	public int age;
	public int score;
	public String Date;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String sex, int age,int score) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.score = score;
	}
	
	public void SetId(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ID");
		int id = scanner.nextInt();
		this.id = id;

	}
	
	public void SetId(int id){
		this.id = id;
	}
	
	public int GetId(){
		//System.out.println("��ѧ����ID��" + this.id);
		return this.id;
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
		System.out.print("������ѧ���Ա�1.��    ����.Ů");	
		int num = scanner.nextInt();
		String sex = SexStatus.getSexStatus(num);
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
	
	public void SetScore(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ѧ���ĳɼ�");
		int score = scanner.nextInt();
		this.score = score;
		
	}
	
	public void GetScore(){
		System.out.println("��ѧ���ĳɼ��ǣ�" + this.score);
	}
	
	public void GetDate(){
		System.out.println("�޸Ļ���ע�����ڣ�" + this.Date);
	}

	public void AddStudent(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ѧ��ID��");
		int id = scanner.nextInt();
		this.id = id;
		System.out.print("������ѧ�����֣�");
		String name = scanner.next();
		this.name = name;
		System.out.print("������ѧ���Ա�1.��    ����.Ů");	
		int num = scanner.nextInt();
		String sex = SexStatus.getSexStatus(num);
		this.sex = sex;
		System.out.print("������ѧ�����䣺");
		int age = scanner.nextInt();
		this.age = age;
		
		System.out.print("������ѧ���ɼ���");
		int score = scanner.nextInt();
		this.score = score;
		
		
	}

	public void ShowStudent(){
		System.out.println("*******************");
		System.out.println("ѧ��ID��" + this.id);
		System.out.println("ѧ��������" + this.name);
		System.out.println("ѧ���Ա�" + this.sex);
		System.out.println("ѧ�����䣺" + this.age);
		System.out.println("ѧ���ɼ���" + this.score);
		System.out.println("����" + this.Date);
	}

	public void Get_Date(){
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String _date = format.format(date);
		
		this.Date = _date;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.score - o.score;
	}
	
	
	
	
}
