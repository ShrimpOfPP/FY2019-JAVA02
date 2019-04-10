package com.neuedu.common;

import java.util.List;

import com.google.gson.Gson;
import com.neuedu.pojo.Student;

/**
 *   ǰ����Ӧ�ĸ߿��ö���
 * */
public class ServerResponse<T> {
	
	private static ServerResponse instance;
	
	private int status;
	private String msg;
	private T data;
	
	private ServerResponse(){}
	
	private ServerResponse(int status){
		this.status = status;
	}
	
	private ServerResponse(int status,String msg){
		this.status = status;
		this.msg = msg;
	}
	
	private ServerResponse(int status,T data){
		this.status = status;
		this.data = data;
	}
	
	private ServerResponse(int status,String msg,T data){
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	/**
	 * �жϽӿ��Ƿ���óɹ�
	 * */
	
	public  boolean isSuccess(){
		
		return this.status==0;
	}
	
	
	/**
	 * status==0,�ӿڵ��óɹ�
	 * {status:0}
	 * 
	 * */
	public static ServerResponse createServerResponseBySuccess(){
		
		return new ServerResponse(0);
	}
	
	/**
	 * status==0,�ӿڵ��óɹ�
	 * {status:0,msg:""}
	 * 
	 * */
	public static ServerResponse createServerResponseBySuccess(String msg){
		
		return new ServerResponse(0,msg);
	}
	
	/**
	 * status==0,�ӿڵ��óɹ�
	 * {status:0,msg:"",data:}
	 * 
	 * */
	public static <T> ServerResponse createServerResponseBySuccess(String msg,T data){
		
		return new ServerResponse(0,msg,data);
	}
	
	

	/**
	 * status!=0,�ӿڵ���ʧ��
	 * {status:}
	 * 
	 * */
	public static ServerResponse createServerResponseByFail(int status){
		
		return new ServerResponse(status);
	}
	
	/**
	 * status!=0,�ӿڵ���ʧ��
	 * {status:,msg:""}
	 * 
	 * */
	public static ServerResponse createServerResponseByFail(int status,String msg){
		
		return new ServerResponse(status,msg);
	}

	
	public String obj2str(){
		Gson gson = new Gson();
		String responseText = gson.toJson(this);
		return responseText;
	}
	
	
	
}
