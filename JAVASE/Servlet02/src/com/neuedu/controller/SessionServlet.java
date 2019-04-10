package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.common.ServerResponse;
import com.neuedu.server.IAdminService;
import com.neuedu.server.ImpL.AdminServerImpL;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//会话
		HttpSession session = request.getSession();
		String JESSIONID = session.getId();
		System.out.println("sessionServlet sessionid:" + JESSIONID);
		
		//判断用户是否登陆过
		Object o = session.getAttribute("user");
		System.out.println(o);
		
		Cookie[] cookies = request.getCookies();
		
		String username = null;
		String password = null;
		
		if(cookies!=null){
			for(int i = 0;i<cookies.length;i++){
				Cookie cookie = cookies[i];
				String cookie_name = cookie.getName();
				String cookie_value = cookie.getValue();
				
				if(cookie_name.equals("username")){
					username = cookie_value;
				}
				if(cookie_name.equals("password")){
					password = cookie_value;
				}
			}
			
		}
		
		
		if(username!=null&&password!=null){
			IAdminService service = AdminServerImpL.getInstance();
			ServerResponse serverResponse = service.login(username, password);
			response.getWriter().write(serverResponse.obj2str());;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
