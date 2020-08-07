package com.currency.exchange.web.dto;

import java.math.BigDecimal;
import java.util.List;

import com.currency.exchange.model.Transaction;

public class AccountStatement {
	

	    BigDecimal currentBalance;
	    List<Transaction> transactionHistory;
		public BigDecimal getCurrentBalance() {
			return currentBalance;
		}
		public void setCurrentBalance(BigDecimal currentBalance) {
			this.currentBalance = currentBalance;
		}
		public List<Transaction> getTransactionHistory() {
			return transactionHistory;
		}
		public void setTransactionHistory(List<Transaction> transactionHistory) {
			this.transactionHistory = transactionHistory;
		}
		public AccountStatement(BigDecimal currentBalance, List<Transaction> transactionHistory) {
			super();
			this.currentBalance = currentBalance;
			this.transactionHistory = transactionHistory;
		}
		public AccountStatement() {
			super();
		}
	    
}
