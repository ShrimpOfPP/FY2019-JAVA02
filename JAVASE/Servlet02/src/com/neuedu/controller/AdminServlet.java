package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neuedu.common.OperationEnum;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Administor;
import com.neuedu.pojo.Student;
import com.neuedu.server.IAdminService;
import com.neuedu.server.ImpL.AdminServerImpL;

/**
 *�������Ա������
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * jsonͳһ��ʽ  int status ״̬ 0:������ýӿڳɹ�,�����ص����ݷ�װ��data 1.�û��������� 2.�������
	 * 				String msg ����
	 * 				Object data
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//�����Ự
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if(operation==null){
			 //���ؿͻ���json��ʽ
			//{"status":3,"msg":"operation�������봫��"}
			//String responseText = "{\"status\":3,\"msg\":\"operation�������봫��\"}";
			
			String responseText = ServerResponse.createServerResponseByFail(3,"operation�������봫��").obj2str(); 
			pw.write(responseText);
			pw.close();
		}
		
		try{
			IAdminService service = AdminServerImpL.getInstance();
			int _operation = Integer.parseInt(operation);
			if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()){//��¼
				//��ȡ�û���
				String username = request.getParameter("username");
				//��ȡ����
				String password = request.getParameter("password");
				
				ServerResponse<Administor> issucc = service.login(username, password);
				
				if(issucc.isSuccess()){
					//��¼�ɹ�
					session.setAttribute("user",true);
					//����cookie
					Cookie username_cookie = new Cookie("username",username);
					//����cookie�Ĺ���ʱ��
					username_cookie.setMaxAge(7*24*3600);
					//��cookieд���ͻ��������
					response.addCookie(username_cookie);
					
					Cookie password_cookie = new Cookie("password",password);
					username_cookie.setMaxAge(7*24*3600);
					response.addCookie(password_cookie);
				}
				String responseText = issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()){//ע��
				//��ȡ�û���
				String username = request.getParameter("username");
				//��ȡ����
				String password = request.getParameter("password");
				
				ServerResponse<Administor> issucc = service.register(username, password);
				String responseText = issucc.obj2str();
				pw.write(responseText);
				pw.close();
			}
			
		}catch(NumberFormatException e){
			//���ؿͻ��ˣ�operation����������
			//{"status":4,"msg":"operation����������"}
			String responseText = "{\"status\":4,\"msg\":\"operation��������������\"}";
			pw.write(responseText);
			pw.close();
		}
		
	}

}
