package com.neuedu.server;

import java.util.List;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Student;

public interface UserBiz {
	ServerResponse<Student> StudentShow(int id);//ѧ����Ϣչʾ
	ServerResponse<Student> StudentShowAll();//չʾ����ѧ����Ϣ
	ServerResponse<Student> StudentAdd(int id,String name,String sex,int score,int age);//ѧ�����
	ServerResponse<Student> StudentDelete(int id);//ѧ��ɾ��
	ServerResponse<Student> StudentModify(int id,String name,String sex,int score,int age);//ѧ����Ϣ�޸�
	public int GetArrayLenth();//��ȡ���鳤��
	void InitStudent();//��ʼ��ѧ��
	void InitStudentList();//��ʼ��ѧ������
	int HalfArrangement(int id);//���ֲ���
	public boolean isexistsstudent(Integer id);
	
}
