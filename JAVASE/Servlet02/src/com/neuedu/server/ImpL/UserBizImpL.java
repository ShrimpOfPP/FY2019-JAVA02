package com.neuedu.server.ImpL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Administor;
import com.neuedu.pojo.Student;
import com.neuedu.server.UserBiz;



public class UserBizImpL implements UserBiz{

	
	private List<Student> list = new ArrayList<Student>();
	private Iterator<Student> it;
	
	private Map<Integer,Student>students = new HashMap<Integer,Student>();
	
	private static UserBizImpL userBizImpL;
	
	private UserBizImpL(){
	
		Student student1 = new Student(1,"张三","男",22,100);
		Student student2 = new Student(2,"李四","男",22,90);
		Student student3 = new Student(3,"王五","女",22,95);
		

		students.put(Integer.valueOf(student1.GetId()), student1);
		students.put(Integer.valueOf(student2.GetId()), student2);
		students.put(Integer.valueOf(student3.GetId()), student3);

		
		System.out.println("Map初始化成功!!!");
		
	}
	
	public static synchronized UserBizImpL getInstance(){
		
		if(userBizImpL==null){
			userBizImpL = new UserBizImpL();
		}
		return userBizImpL;
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
		System.out.println("集合初始化成功!!!");
	}
	
	
	public int getID(int id){//获取ID
		int z = HalfArrangement(id);
		if(z==-1){
			return -1;
		}else{
			return this.list.get(z).id;
		}
		
	}
	
	public String getName(int id){//获取名字
		int z = HalfArrangement(id);
		if(z==-1){
			return "null";
		}else{
			return this.list.get(z).name;
		}
	}
	
	public String getSex(int id){//获取性别
		int z = HalfArrangement(id);
		if(z==-1){
			return "null";
		}else{
			return this.list.get(z).sex;
		}
		
	}
	
	public int getAge(int id){//获取年龄
		int z = HalfArrangement(id);
		if(z==-1){

			return -1;
		}else{
			return this.list.get(z).age;
		}
		
	}
	
	public int getScore(int id){//获取成绩
		int z = HalfArrangement(id);
		if(z==-1){
			return -1;
		}else{
			return this.list.get(z).score;
		}
	}
	
	public String getDate(int id){//获取日期
		int z = HalfArrangement(id);
		if(z==-1){
			return "null";
		}else{
			return this.list.get(z).Date;
		}
	}
	
	public List<Object> AllStudentMessage(){//获取所有学生信息
		List<Object> listReturn = new ArrayList<Object>();
		for(int i = 0;i < this.list.size();i++){
			listReturn.add(this.list.get(i).id);
			listReturn.add(this.list.get(i).name);
			listReturn.add(this.list.get(i).sex);
			listReturn.add(this.list.get(i).age);
			listReturn.add(this.list.get(i).score);
			listReturn.add(this.list.get(i).Date);
		}
		
		return listReturn;
		
	}
	
	@Override
	public ServerResponse<Student> StudentShow(int id) {
		// TODO Auto-generated method stub
		boolean isexistsstudent = isexistsstudent(id);
		
		if(isexistsstudent){
			Student student = students.get(id);
			if(student.GetId()==id){
				return ServerResponse.createServerResponseBySuccess("查找成功", student);
			}
		}
		return ServerResponse.createServerResponseByFail(7, "没有该ID");
	}
	

	@Override
	public ServerResponse<Student> StudentAdd(int id,String name,String sex,int score,int age) {
		// TODO Auto-generated method stub
		boolean isexistsstudent = isexistsstudent(id);
		
		if(isexistsstudent){
			return ServerResponse.createServerResponseByFail(8, "ID已存在");
		}
		Student student =new Student(id,name,sex,score,age);
		
		return ServerResponse.createServerResponseBySuccess("添加成功", student);
		
	}

	@Override
	public ServerResponse<Student> StudentDelete(int id) {
		// TODO Auto-generated method stub
		boolean isexistsstudent = isexistsstudent(id);
		if(isexistsstudent){
			students.remove(id);
			return ServerResponse.createServerResponseBySuccess("删除成功");
		}
		return ServerResponse.createServerResponseByFail(7, "ID不存在");
	}

	@Override
	public ServerResponse<Student> StudentModify(int id,String name,String sex,int score,int age) {
		
		boolean isexistsstudent = isexistsstudent(id);
		if(isexistsstudent){
			Student student =new Student(id,name,sex,score,age);
			return ServerResponse.createServerResponseBySuccess("修改成功",student);
		}
		
		return ServerResponse.createServerResponseByFail(7, "ID不存在");
		

	}

	@Override
	public int GetArrayLenth() {
		// TODO Auto-generated method stub
		
		return list.size();
	}

	@Override
	public int HalfArrangement(int id) {
		// TODO Auto-generated method stub
		Student temp = new Student();
		//id顺序排列
		for(int i = 0;i < list.size();i++){
			for(int j = 0;j < list.size()-i-1;j++){
				if(list.get(j+1)!=null){
					if(list.get(j).id > list.get(j+1).id){
						 temp = list.get(j);
						 list.set(j,list.get(j+1));
						 list.set(j+1,temp);
					}
				}
			}
		}
		
		int x = 0;
		int y = list.size()-1;
		int z = (x+y)/2;
		
		while(x<=y){
			if(id>list.get(z).id){
				x = z+1;
			}else if(id<list.get(z).id){
				y = z-1;
			}else{
				return z;
			}
			z = (x+y)/2;
		}

		return -1;
		
	}

	@Override
	public void InitStudent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServerResponse<Student> StudentShowAll() {
		// TODO Auto-generated method stub
		//List<Student> list = new ArrayList<Student>();
		Collection<Student> list =  students.values();
		return ServerResponse.createServerResponseBySuccess("查找全部成功",list);
	}

	@Override
	public boolean isexistsstudent(Integer id) {
		// TODO Auto-generated method stub
		return students.containsKey(id);
	}

}
