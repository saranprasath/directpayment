package com.currency.exchange.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.exchange.model.CurrencyRates;
@Repository 
public interface ExchangeRepo extends JpaRepository<CurrencyRates,Integer>{
	CurrencyRates findByBaseCurrencyEquals(String BaseCurrency);

		
}

