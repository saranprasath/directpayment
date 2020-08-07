package com.currency.exchange.web.dto;

import java.math.BigDecimal;

public class TransferBalanceRequest {
	
	    private String fromAccountNumber;

	    private String toAccountNumber;

	    private BigDecimal amount;

	    private String BaseCurrency;
	    
	    private String ToCurrency;
		public String getFromAccountNumber() {
			return fromAccountNumber;
		}

		public void setFromAccountNumber(String fromAccountNumber) {
			this.fromAccountNumber = fromAccountNumber;
		}

		public String getToAccountNumber() {
			return toAccountNumber;
		}

		public void setToAccountNumber(String toAccountNumber) {
			this.toAccountNumber = toAccountNumber;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		
		public String getBaseCurrency() {
			return BaseCurrency;
		}

		public void setBaseCurrency(String baseCurrency) {
			BaseCurrency = baseCurrency;
		}

		public String getToCurrency() {
			return ToCurrency;
		}

		public void setToCurrency(String toCurrency) {
			ToCurrency = toCurrency;
		}

		public TransferBalanceRequest(String fromAccountNumber, String toAccountNumber, BigDecimal amount,
				String baseCurrency, String toCurrency) {
			super();
			this.fromAccountNumber = fromAccountNumber;
			this.toAccountNumber = toAccountNumber;
			this.amount = amount;
			BaseCurrency = baseCurrency;
			ToCurrency = toCurrency;
		}

		public TransferBalanceRequest() {
			super();
		}

	
}
