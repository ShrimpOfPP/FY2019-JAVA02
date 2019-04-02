package com.neuedu.server.ImpL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.neuedu.pojo.Student;
import com.neuedu.server.UserBiz;



public class UserBizImpL implements UserBiz{

	private Student student[] = new Student[3];
	private List<Student> list = new ArrayList<Student>();
	private Iterator<Student> it;
	
	private static UserBizImpL userBizImpL;
	
	private UserBizImpL(){
		
		Student student1 = new Student(1,"张三","男",22,100);
		Student student2 = new Student(2,"李四","男",22,90);
		Student student3 = new Student(3,"王五","女",22,95);
		
		student1.Get_Date();
		student2.Get_Date();
		student3.Get_Date();
		
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		
		
		Collections.sort(list);
		it = list.iterator();
		
	}
	
	public static UserBizImpL getInstance(){
		
		if(userBizImpL==null){
			userBizImpL = new UserBizImpL();
		}
		return userBizImpL;
	}
	
	//初始化学生数组
	public void InitStudent(){
		this.student[0] =new Student(1,"张三","男",22,96);
		this.student[1] =new Student(2,"李四","男",16,99);
		this.student[2] =new Student(3,"王五","女",20,100);
		
		System.out.println("数组初始化成功!!!");
	}
	
	//初始化学生集合
	public void InitStudentList(){
		Student student1 = new Student(1,"张三","男",22,100);
		Student student2 = new Student(2,"李四","男",22,90);
		Student student3 = new Student(3,"王五","女",22,95);
		
		student1.Get_Date();
		student2.Get_Date();
		student3.Get_Date();
		
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		
		
		Collections.sort(list);
		it = list.iterator();
		
		/*while(it.hasNext()){
			Student o = it.next();
			o.ShowStudent();
		}*/
		
		System.out.println("集合初始化成功!!!");
		
	}
	
	
	@Override
	public void StudentShow(int id) {
		// TODO Auto-generated method stub
		/*for(int i = 0;i<this.student.length;i++){
			if(id==this.student[i].id){
				this.student[i].ShowStudent();
				break;
			}
			if(i==this.student.length-1 && id!=this.student[i].id){
				System.out.println("没有该id");
			}
		}*/
		//集合的学生展示
		for(int i = 0;i < list.size();i++){
			 if(list.get(i).id==id){
					Student o = list.get(i);
					o.ShowStudent();
					break;
				}
			 else if(list.get(i).id!=id && i==list.size()-1){
					System.out.println("没有该ID");
				}
		}
		
		
		
	}
	

	@Override
	public void StudentAdd(int id) {
		// TODO Auto-generated method stub
		/*for(int i=0;i<student.length;i++){
			if(id!=student[i].id && i==student.length-1){
				System.out.println("****************添加学生信息*****************************");
				Student t = new Student(0,"0","0",0,0);
				//t.AddStudent();//添加学生个人信息
				t.id = id;
				t.SetName();
				t.SetSex();
				t.SetAge();
				t.SetScore();
				
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
		}*/
		
		//集合里添加学生
		for(int i=0;i < list.size();i++){
			if(list.get(i).id!=id && i==list.size()-1){
				System.out.println("****************添加学生信息*****************************");
				Student t = new Student(0,"0","0",0,0);
				t.id = id;
				t.SetName();
				t.SetSex();
				t.SetAge();
				t.SetScore();
				t.Get_Date();
				list.add(t);
				Collections.sort(list);
				it = list.iterator();
				for(i = 0;i < list.size();i++){
					list.get(i).ShowStudent();
				}
				break;
			}else if(id==list.get(i).id){
				System.out.println("ID已存在，请重新输入");
				break;
			}
		}
		
	}

	@Override
	public void StudentDelete(int id) {
		// TODO Auto-generated method stub
		/*Student[] stu = new Student[this.student.length-1];//保存更新后的学生信息
		for(int i = 0;i < this.student.length;i++){
			if(this.student[i].id == id){
				if(i==0){
					System.arraycopy(this.student, i+1, stu, 0, this.student.length-1);
				}else if(i==this.student.length-1){
					System.arraycopy(this.student, 0, stu, 0, this.student.length-1);
				}else{
					System.arraycopy(this.student, 0, stu, 0, i);
					System.arraycopy(this.student, i+1, stu, i, this.student.length-1-i);
				}
				this.student = stu;//更新原数组
				System.out.print("删除成功！");
				for(int j = 0;j < this.student.length;j++){
					this.student[j].ShowStudent();
				}
				break;
			}
			if(i==this.student.length-1 && id!=this.student[i].id){
				System.out.println("没有该id");
			}
		}*/
		
		//集合删除学生信息
		for(int i=0;i < list.size();i++){
			if(list.get(i).id==id){
				list.remove(i);
				System.out.print("删除成功！");
				for(i = 0;i < list.size();i++){
					list.get(i).ShowStudent();
				}
				break;
			}
			if(id!=list.get(i).id && i==list.size()-1){
				System.out.println("ID不存在，请重新输入");
				break;
			}
		}
	}

	@Override
	public void StudentModify(int id) {
		// TODO Auto-generated method stub
		
		/*for(int i = 0;i < this.student.length;i++){
			if(this.student[i].id==id){
					System.out.println("1.修改ID 2.修改名字  3.修改性别   4.修改年龄  5.全部修改 ");
					System.out.print("请输入需要操作的数字:");
					int num = scanner.nextInt();
					if(num==1){
						System.out.println("请输入新的ID");
						int id1 = scanner.nextInt();
						for(int k=0;k<this.student.length;k++){
							if(id1!=this.student[k].id && k==this.student.length-1){
								this.student[i].id = id1;
								break;
							}else if(id1==this.student[k].id){
								System.out.println("ID已存在，请重新输入");
								break;
							}
						}
						//student[i].SetId();
						this.student[i].GetId();
						break;
					}else if(num==2){
						this.student[i].SetName();
						this.student[i].GetName();
						break;
					}else if(num==3){
						this.student[i].SetSex();
						this.student[i].GetSex();
						break;
					}else if(num==4){
						this.student[i].SetAge();
						this.student[i].GetAge();
						break;
					}else if(num==5){
						this.student[i].SetId();
						this.student[i].GetId();
						this.student[i].SetName();
						this.student[i].GetName();
						this.student[i].SetSex();
						this.student[i].GetSex();
						this.student[i].SetAge();
						this.student[i].GetAge();
						break;
					}
				
			}
			if(i==this.student.length-1 && id!=this.student[i].id){
				System.out.println("没有该id");
			}
		}*/	
		
		//集合修改学生信息
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0;i < list.size();i++){
			if(id==list.get(i).id){
				System.out.println("1.修改ID 2.修改名字  3.修改性别   4.修改年龄  5.修改成绩  6.全部修改");
				System.out.print("请输入需要操作的数字:");
				int num = scanner.nextInt();
				if(num==1){
					System.out.println("请输入新的ID");
					int id1 = scanner.nextInt();
					for(int k=0;k<list.size();k++){
						if(id1!=list.get(i).id && k==list.size()-1){
							list.get(i).id = id1;
							break;
						}else if(id1==list.get(i).id){
							System.out.println("ID已存在，请重新输入");
							break;
						}
					}
					//student[i].SetId();
					list.get(i).GetId();
					break;
				}else if(num==2){
					list.get(i).SetName();
					list.get(i).GetName();
					break;
				}else if(num==3){
					list.get(i).SetSex();
					list.get(i).GetSex();
					break;
				}else if(num==4){
					list.get(i).SetAge();
					list.get(i).GetAge();
					break;
				}else if(num==5){
					list.get(i).SetScore();
					list.get(i).GetScore();    
					Collections.sort(list);
					it = list.iterator();
					for(int k = 0;k < list.size();k++){
						list.get(k).ShowStudent();
					}
					break;
				}else if(num==6){
					list.get(i).SetId();
					list.get(i).GetId();
					list.get(i).SetName();
					list.get(i).GetName();
					list.get(i).SetSex();
					list.get(i).GetSex();
					list.get(i).SetAge();
					list.get(i).GetAge();
					Collections.sort(list);
					it = list.iterator();
					for(int k = 0;k < list.size();k++){
						list.get(k).ShowStudent();
					}
					break;
				}
				
			}
			else if(id!=list.get(i).id && i==list.size()-1){
				System.out.println("ID不存在，请重新输入");
				break;
			}
		}
		
		
	}

	@Override
	public int GetArrayLenth() {
		// TODO Auto-generated method stub
		
		return list.size();
	}

}
