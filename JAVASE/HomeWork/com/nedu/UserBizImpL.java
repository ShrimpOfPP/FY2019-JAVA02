package com.nedu;



public class UserBizImpL implements UserBiz{

	public User user[] = new User[2];

	UserBizImpL(){
		
	}
	
	

	@Override
	public  void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
		// TODO Auto-generated method stub
		if(!password.equals(password2)){
			throw new RegisterException("���벻һ��");
		}
		
		for(int i = 0;i<user.length;i++){
			if(user[i].username.equals(username)){
				throw new RegisterException("�û����ظ�");
			}
		}
		
		User user1 = new User();
		user1.username = username;
		user1.password = password;
		user1.name = name;
		user1.email = email;
		
		User newuser[] = new User[user.length+1];
		System.arraycopy(user, 0, newuser, 0, user.length);
		newuser[user.length] = user1;
		user = newuser;
		
		System.out.println("ע���û��ɹ�");
	}

	@Override
	public void login(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		for(int i = 0;i < user.length;i++){
			if(!(user[i].username.equals(username))){
				if(i==user.length-1){
					throw new LoginException("username������");
				}
					continue;
			}else{
				break;
			}
		}
		
		for(int i = 0;i < user.length;i++){
			if(username.equals(user[i].username)){
				if(!password.equals(user[i].password)){
					throw new LoginException("username��password��ƥ��");
				};
			}
		}
		System.out.println("��½�ɹ�");
	}

	@Override
	public void GetUserArray() {
		// TODO Auto-generated method stub
		User user = new User("admin","admin","Administrator","admin@123.com");
		User user1 = new User("tom","cat","tomcat","tomcat@123.com");
		
		this.user[0] = user;
		this.user[1] = user1;
	}
	
	
}



