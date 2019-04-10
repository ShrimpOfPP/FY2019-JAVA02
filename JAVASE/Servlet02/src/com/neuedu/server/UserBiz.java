package com.neuedu.server;

import java.util.List;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Student;

public interface UserBiz {
	ServerResponse<Student> StudentShow(int id);//学生信息展示
	ServerResponse<Student> StudentShowAll();//展示所有学生信息
	ServerResponse<Student> StudentAdd(int id,String name,String sex,int score,int age);//学生添加
	ServerResponse<Student> StudentDelete(int id);//学生删除
	ServerResponse<Student> StudentModify(int id,String name,String sex,int score,int age);//学生信息修改
	public int GetArrayLenth();//获取数组长度
	void InitStudent();//初始化学生
	void InitStudentList();//初始化学生数组
	int HalfArrangement(int id);//二分查找
	public boolean isexistsstudent(Integer id);
	
}
