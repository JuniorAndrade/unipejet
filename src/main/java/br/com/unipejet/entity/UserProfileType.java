package br.com.unipejet.entity;

import java.io.Serializable;

public enum UserProfileType implements Serializable {

	USER("USER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
