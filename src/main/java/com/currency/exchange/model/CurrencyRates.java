package com.currency.exchange.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rates")
public class CurrencyRates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String baseCurrency;
	private String targetCurrency;
	private BigDecimal multipleAmount;
	
	
	public CurrencyRates() {
		
	}
	public CurrencyRates( String baseCurrency, String targetCurrency, BigDecimal multipleAmount) {
		super();
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.multipleAmount = multipleAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public BigDecimal getMultipleAmount() {
		return multipleAmount;
	}
	public void setMultipleAmount(BigDecimal multipleAmount) {
		this.multipleAmount = multipleAmount;
	}
	
	
	

}
