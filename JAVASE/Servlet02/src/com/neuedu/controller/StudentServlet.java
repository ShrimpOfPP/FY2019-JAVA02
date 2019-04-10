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
	 * json统一格式  int status 状态 0:查看单个学生信息
	 *  1.查看所有学生信息  2.添加学生信息  3.删除学生信息 4.修改学生信息
	 *  5.操作数为空 6.操作数不正确
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		String operation = request.getParameter("operation");
		String ID = request.getParameter("ID");
		if(operation==null){
			 //返回客户端json格式
			//{"status":5,"msg":"operation参数必须传递"}
			String responseText = ServerResponse.createServerResponseByFail(5,"operation参数必须传递").obj2str();
			pw.write(responseText);
			pw.close();
		}
		
		try{
			UserBizImpL userBizImpL = UserBizImpL.getInstance();//集合初始化成功
			int _operation = Integer.parseInt(operation);
			int _ID = Integer.parseInt(ID);
			if(_operation==0){//查看单个学生
				
				//String responseText = "{\"status\":0,\"msg\":\"查看单个学生信息\",\"data:{"+ " ID:" + userBizImpL.getID(_ID) + " 姓名:" + userBizImpL.getName(_ID) + " 性别:" + userBizImpL.getSex(_ID) + " 年龄:" + userBizImpL.getAge(_ID) + " 成绩:" + userBizImpL.getScore(_ID) + " 日期:" + userBizImpL.getDate(_ID) +"}\"}";
				ServerResponse<Student> issucc = userBizImpL.StudentShow(_ID);
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==1){//查看所有学生
				ServerResponse<Student> issucc = userBizImpL.StudentShowAll();
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==2){//添加学生信息
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
				
			}else if(_operation==3){//删除学生信息
				//String responseText = "{\"status\":3,\"msg\":\"删除学生信息\"}";
				ServerResponse<Student> issucc = userBizImpL.StudentDelete(_ID);
				String responseText =issucc.obj2str();
				pw.write(responseText);
				pw.close();
				
			}else if(_operation==4){//修改学生信息
				//String responseText = "{\"status\":4,\"msg\":\"修改学生信息\"}";
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
			//返回客户端，operation必须是数字
			//{"status":6,"msg":"operation必须是数字"}
			String responseText = "{\"status\":6,\"msg\":\"operation参数必须是数字\"}";
			pw.write(responseText);
			pw.close();
		}
	}

}
