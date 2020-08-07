package com.currency.exchange.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.exchange.model.User;

@Repository
public interface Userrepository extends JpaRepository<User, Long>{
	User findByUsername(String Username);
	User findByAccnoEquals(String accountNumber);
}

