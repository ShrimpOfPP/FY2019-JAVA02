package com.neuedu.pojo;

public enum SexStatus {
	
		Man("ÄÐ"),
		WonMan("Å®");
	;
	private String sexStatus;
	
	SexStatus(String sexStatus){
		this.sexStatus = sexStatus;
		
	}
	public String getSex(){
		return this.sexStatus;
	}
	
	public static String getSexStatus(int num){
		if(num==1){
			return SexStatus.Man.getSex();
		}else {
			return SexStatus.WonMan.getSex();
		}
		
	}
}
