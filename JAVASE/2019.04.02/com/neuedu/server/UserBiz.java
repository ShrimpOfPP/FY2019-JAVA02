package com.neuedu.server;

public interface UserBiz {
	void StudentShow(int id);//学生信息展示
	void StudentAdd(int id);//学生添加
	void StudentDelete(int id);//学生删除
	void StudentModify(int id);//学生信息修改
	public int GetArrayLenth();//获取数组长度
	void InitStudent();//初始化学生
	void InitStudentList();//初始化学生数组
}
