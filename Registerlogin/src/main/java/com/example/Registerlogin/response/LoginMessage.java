package com.example.Registerlogin.response;

public class LoginMessage {

	
	public LoginMessage(int id,String messsage, Boolean status) {
		super();
		this.messsage = messsage;
		this.status = status;
		this.id=id;
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String messsage;
	Boolean status;
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
