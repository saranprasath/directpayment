package com.currency.exchange.web.dto;

import java.math.BigDecimal;

public class CurrencyRate {

	private String baseCurrency;
	private String targetCurrency;
	private BigDecimal multipleAmount;
	public CurrencyRate() {
	
	}
	public CurrencyRate(String baseCurrency, String targetCurrency, BigDecimal multipleAmount) {
		super();
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.multipleAmount = multipleAmount;
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
