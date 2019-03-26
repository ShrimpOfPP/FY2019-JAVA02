package com.nedu;

public class UserBizImpL implements UserBiz{

	public User user[] = new User[2];

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User("admin","admin","Administrator","admin@123.com");
		User user1 = new User("tom","cat","tomcat","tomcat@123.com");
		UserBizImpL userBizImpL = null;
		userBizImpL.user[0] = user;
		userBizImpL.user[1] = user1;
		
	}

	@Override
	public  void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
		// TODO Auto-generated method stub
		if(!password.equals(password2)){
			throw new RegisterException("密码不一致");
		}
		
		for(int i = 0;i<user.length;i++){
			if(user[i].name.equals(username)){
				throw new RegisterException("用户名重复");
			}
		}
		
		
	}

	
	@Override
	public void login(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		for(int i = 0;i < user.length;i++){
			if(!(user[i].name.equals(username))){
				if(user.length==i){
					throw new LoginException("username不存在");
				}
				continue;
			}else{
				break;
			}
		}
		
		for(int i = 0;i < user.length;i++){
			if(username.equals(user[i].username)){
				if(!password.equals(user[i].password)){
					throw new LoginException("username和password不匹配");
				};
			}
		}
		
	}
}



