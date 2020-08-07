package com.currency.exchange.model;
import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long cus_id;
 private String username;
public Role()
{}
public Role(String username) {
	super();
	this.username = username;
}
public Long getId() {
	return cus_id;
}
public void setId(Long cus_id) {
	this.cus_id = cus_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
 
 
}
