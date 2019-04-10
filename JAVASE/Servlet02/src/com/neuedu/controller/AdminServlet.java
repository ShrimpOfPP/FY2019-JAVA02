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
 *处理管理员的请求
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
	 * json统一格式  int status 状态 0:代表调用接口成功,将返回的数据封装到data 1.用户名不存在 2.密码错误
	 * 				String msg 描述
	 * 				Object data
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//创建会话
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		String operation = request.getParameter("operation");
		if(operation==null){
			 //返回客户端json格式
			//{"status":3,"msg":"operation参数必须传递"}
			//String responseText = "{\"status\":3,\"msg\":\"operation参数必须传递\"}";
			
			String responseText = ServerResponse.createServerResponseByFail(3,"operation参数必须传递").obj2str(); 
			pw.write(responseText);
			pw.close();
		}
		
		try{
			IAdminService service = AdminServerImpL.getInstance();
			int _operation = Integer.parseInt(operation);
			if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()){//登录
				//获取用户名
				String username = request.getParameter("username");
				//获取密码
				String password = request.getParameter("password");
				
				ServerResponse<Administor> issucc = service.login(username, password);
				
				if(issucc.isSuccess()){
					//登录成功
					session.setAttribute("user",true);
					//创建cookie
					Cookie username_cookie = new Cookie("username",username);
					//设置cookie的过期时间
					username_cookie.setMaxAge(7*24*3600);
					//将cookie写到客户端浏览器
					response.addCookie(username_cookie);
					
					Cookie password_cookie = new Cookie("password",password);
					username_cookie.setMaxAge(7*24*3600);
					response.addCookie(password_cookie);
				}
				String responseText = issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()){//注册
				//获取用户名
				String username = request.getParameter("username");
				//获取密码
				String password = request.getParameter("password");
				
				ServerResponse<Administor> issucc = service.register(username, password);
				String responseText = issucc.obj2str();
				pw.write(responseText);
				pw.close();
			}
			
		}catch(NumberFormatException e){
			//返回客户端，operation必须是数字
			//{"status":4,"msg":"operation必须是数字"}
			String responseText = "{\"status\":4,\"msg\":\"operation参数必须是数字\"}";
			pw.write(responseText);
			pw.close();
		}
		
	}

}
