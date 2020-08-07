package com.currency.exchange.web.dto;

public class UserLogin {
   String Username;
   String password;
public UserLogin(String username, String password) {
	super();
	Username = username;
	this.password = password;
}
public UserLogin() {
	super();
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   
}
