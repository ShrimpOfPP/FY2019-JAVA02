package com.neuedu.server;

public interface UserBiz {
	void StudentShow(int id);//ѧ����Ϣչʾ
	void StudentAdd(int id);//ѧ�����
	void StudentDelete(int id);//ѧ��ɾ��
	void StudentModify(int id);//ѧ����Ϣ�޸�
	public int GetArrayLenth();//��ȡ���鳤��
	void InitStudent();//��ʼ��ѧ��
	void InitStudentList();//��ʼ��ѧ������
}
