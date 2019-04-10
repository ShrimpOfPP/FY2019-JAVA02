package com.neuedu.server;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Administor;

/**
 * 管理员业务逻辑的处理
 * */
public interface IAdminService {

	public ServerResponse<Administor> login(String username,String password);
	public ServerResponse<Administor> register(String username,String password);
	public Administor init(String username,String password);
	public boolean isexistsusername(String username);
}
