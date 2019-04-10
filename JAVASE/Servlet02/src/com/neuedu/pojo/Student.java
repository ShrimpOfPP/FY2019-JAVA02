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
		System.out.println("请输入ID");
		int id = scanner.nextInt();
		this.id = id;

	}
	
	public void SetId(int id){
		this.id = id;
	}
	
	public int GetId(){
		//System.out.println("该学生的ID：" + this.id);
		return this.id;
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
		System.out.print("请输入学生性别：1.男    其他.女");	
		int num = scanner.nextInt();
		String sex = SexStatus.getSexStatus(num);
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
	
	public void SetScore(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生的成绩");
		int score = scanner.nextInt();
		this.score = score;
		
	}
	
	public void GetScore(){
		System.out.println("该学生的成绩是：" + this.score);
	}
	
	public void GetDate(){
		System.out.println("修改或者注册日期：" + this.Date);
	}

	public void AddStudent(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入学生ID：");
		int id = scanner.nextInt();
		this.id = id;
		System.out.print("请输入学生名字：");
		String name = scanner.next();
		this.name = name;
		System.out.print("请输入学生性别：1.男    其他.女");	
		int num = scanner.nextInt();
		String sex = SexStatus.getSexStatus(num);
		this.sex = sex;
		System.out.print("请输入学生年龄：");
		int age = scanner.nextInt();
		this.age = age;
		
		System.out.print("请输入学生成绩：");
		int score = scanner.nextInt();
		this.score = score;
		
		
	}

	public void ShowStudent(){
		System.out.println("*******************");
		System.out.println("学生ID：" + this.id);
		System.out.println("学生姓名：" + this.name);
		System.out.println("学生性别：" + this.sex);
		System.out.println("学生年龄：" + this.age);
		System.out.println("学生成绩：" + this.score);
		System.out.println("日期" + this.Date);
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
