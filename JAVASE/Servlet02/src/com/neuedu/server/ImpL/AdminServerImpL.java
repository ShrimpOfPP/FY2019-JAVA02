package com.neuedu.server.ImpL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Administor;
import com.neuedu.pojo.Student;
import com.neuedu.server.IAdminService;

public class AdminServerImpL implements IAdminService {

	String username;
	String password;
	
	Map<String,Administor> admins = new HashMap<String,Administor>();
	Map<Integer,Student>map2;
	
	private List<Administor> list = new ArrayList<Administor>();
	private static AdminServerImpL adminServerImpL;
	
	private  AdminServerImpL(){
		
		Administor user1 = new Administor("admin","admin");
		admins.put(user1.getUsername(), user1);
	}
	
	public static synchronized AdminServerImpL getInstance(){
		if(adminServerImpL==null){
			adminServerImpL = new AdminServerImpL();
		}
		return adminServerImpL;
	}

	@Override
	public ServerResponse<Administor> login(String username, String password) {
		// TODO Auto-generated method stub
		
		boolean isexistsusername = isexistsusername(username);
		if(isexistsusername){
			Administor admin = admins.get(username);
			if(admin.username.equals(username)){//用户名相同
				
				if(admin.password.equals(password)){
					return ServerResponse.createServerResponseBySuccess("登陆成功", admin);
				}else{
					return ServerResponse.createServerResponseByFail(1, "用户名和密码不匹配");
				}
			}
		}
		return ServerResponse.createServerResponseByFail(6, "用户名不存在");
		
	}

	@Override
	public ServerResponse<Administor> register(String username, String password) {
		// TODO Auto-generated method stub
		boolean isexistsusername = isexistsusername(username);
		if(isexistsusername){
			return  ServerResponse.createServerResponseByFail(7, "注册重命名");
		}
		Administor a = adminServerImpL.init(username, password);
		admins.put(a.getUsername(), a);
		return ServerResponse.createServerResponseBySuccess("注册成功", a);
	}

	@Override
	public Administor init(String username, String password) {
		// TODO Auto-generated method stub
		Administor a = new Administor();
		a.setUsername(username);
		a.setPassword(password);
		//list.add(a);
		admins.put(a.getUsername(), a);
		System.out.println("添加成功");
		return a;
	}

	@Override
	public boolean isexistsusername(String username) {
		// TODO Auto-generated method stub
		return admins.containsKey(username);
	}
}
