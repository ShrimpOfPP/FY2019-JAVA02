package com.neuedu.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Administor;
import com.neuedu.pojo.Student;
import com.neuedu.server.ImpL.UserBizImpL;



/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * jsonͳһ��ʽ  int status ״̬ 0:�鿴����ѧ����Ϣ
	 *  1.�鿴����ѧ����Ϣ  2.���ѧ����Ϣ  3.ɾ��ѧ����Ϣ 4.�޸�ѧ����Ϣ
	 *  5.������Ϊ�� 6.����������ȷ
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		String operation = request.getParameter("operation");
		String ID = request.getParameter("ID");
		if(operation==null){
			 //���ؿͻ���json��ʽ
			//{"status":5,"msg":"operation�������봫��"}
			String responseText = ServerResponse.createServerResponseByFail(5,"operation�������봫��").obj2str();
			pw.write(responseText);
			pw.close();
		}
		
		try{
			UserBizImpL userBizImpL = UserBizImpL.getInstance();//���ϳ�ʼ���ɹ�
			int _operation = Integer.parseInt(operation);
			int _ID = Integer.parseInt(ID);
			if(_operation==0){//�鿴����ѧ��
				
				//String responseText = "{\"status\":0,\"msg\":\"�鿴����ѧ����Ϣ\",\"data:{"+ " ID:" + userBizImpL.getID(_ID) + " ����:" + userBizImpL.getName(_ID) + " �Ա�:" + userBizImpL.getSex(_ID) + " ����:" + userBizImpL.getAge(_ID) + " �ɼ�:" + userBizImpL.getScore(_ID) + " ����:" + userBizImpL.getDate(_ID) +"}\"}";
				ServerResponse<Student> issucc = userBizImpL.StudentShow(_ID);
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==1){//�鿴����ѧ��
				ServerResponse<Student> issucc = userBizImpL.StudentShowAll();
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==2){//���ѧ����Ϣ
				String name = request.getParameter("name");
				String sex = request.getParameter("sex");
				String score = request.getParameter("score");
				int _score = Integer.parseInt(score);
				String age = request.getParameter("age");
				int _age = Integer.parseInt(age);
				ServerResponse<Student> issucc = userBizImpL.StudentAdd(_ID,name,sex,_score,_age);
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==3){//ɾ��ѧ����Ϣ
				//String responseText = "{\"status\":3,\"msg\":\"ɾ��ѧ����Ϣ\"}";
				ServerResponse<Student> issucc = userBizImpL.StudentDelete(_ID);
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==4){//�޸�ѧ����Ϣ
				//String responseText = "{\"status\":4,\"msg\":\"�޸�ѧ����Ϣ\"}";
				String name = request.getParameter("name");
				String sex = request.getParameter("sex");
				String score = request.getParameter("score");
				int _score = Integer.parseInt(score);
				String age = request.getParameter("age");
				int _age = Integer.parseInt(age);
				ServerResponse<Student> issucc = userBizImpL.StudentModify(_ID, name, sex,_score,_age);
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
			}
			
		}catch(NumberFormatException e){
			//���ؿͻ��ˣ�operation����������
			//{"status":6,"msg":"operation����������"}
			String responseText = "{\"status\":6,\"msg\":\"operation��������������\"}";
			pw.write(responseText);
			pw.close();
		}
	}

}
