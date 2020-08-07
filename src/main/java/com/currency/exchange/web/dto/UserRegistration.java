package com.currency.exchange.web.dto;

import java.math.BigDecimal;

public class UserRegistration {
 private String username;
 private String Email;
 private String password;
 private String account_no;
 private String currencytype;
 private  BigDecimal currentBalance;
 
 public UserRegistration()
 {
	 
 }
 
public UserRegistration(String username, String email, String password, String account_no, String currencytype,
		BigDecimal currentBalance) {
	super();
	this.username = username;
	Email = email;
	this.password = password;
	this.account_no = account_no;
	this.currencytype = currencytype;
	this.currentBalance = currentBalance;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAccount_no() {
	return account_no;
}
public void setAccount_no(String account_no) {
	this.account_no = account_no;
}
public String getCurrencytype() {
	return currencytype;
}
public void setCurrencytype(String currencytype) {
	this.currencytype = currencytype;
}

public BigDecimal getCurrentBalance() {
	return currentBalance;
}

public void setCurrentBalance(BigDecimal currentBalance) {
	this.currentBalance = currentBalance;
}


 
 

 
}
