package com.nedu;

public class User {
	protected String username;
	protected String password;
	protected String name;
	protected String email;
	
	public User(String username,String password,String name,String email){
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	public void SetUsername(String username){
		this.username = username;
	}
	public void GetUsername(){
		System.out.println(this.username);
	}
	
	public void SetPassWord(String password){
		this.password = password;
	}
	public void GetPassWord(){
		System.out.println(this.password);
	}
	
	public void SetName(String name){
		this.name = name;
	}
	public void GetName(){
		System.out.println(this.name);
	}
	
	public void SetEmail(String email){
		this.email = email;
	}
	public void GetEmail(){
		System.out.println(this.email);
	}
	
	
}
