package com.currency.exchange.model;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.*;
@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames={"username","accno"}))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cus_id;
	@Column(name="username")
    private String username;
	@Column (name="email")
	private String email;
    private String password; 
    private String accno;
    private String currencytype;
    private BigDecimal currentBalance;
    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
    		name="users_process",
    		joinColumns = @JoinColumn(
    				name="user_id",referencedColumnName="cus_id"),
    		inverseJoinColumns=@JoinColumn(
    				name="role_id",referencedColumnName="cus_id"))
    private Collection<Role> roles;
    
    public User()
    {
    	
    }
   
	public User(String username, String email, String password, String accno, String currencytype,  BigDecimal currentBalance,
			Collection<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.accno = accno;
		this.currencytype = currencytype;
		this.currentBalance=currentBalance;
		this.roles=roles;
	}
	public Long getCus_id() {
		return cus_id;
	}
	public void setCus_id(Long cus_id) {
		this.cus_id = cus_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public User(Collection<Role> roles) {
		super();
		this.roles = roles;
	}


	
	
	
    
}
