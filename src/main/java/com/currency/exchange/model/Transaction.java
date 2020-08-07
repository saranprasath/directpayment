package com.currency.exchange.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
    @GeneratedValue
    private Long transactionId;

    private String fromaccountNumber;

    private String toAccountNumber;
    
    private BigDecimal transactionAmount;

    private Timestamp transactionDateTime;

	
	public String getFromaccountNumber() {
		return fromaccountNumber;
	}

	public void setFromaccountNumber(String fromaccountNumber) {
		this.fromaccountNumber = fromaccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public Transaction(Long transactionId, String fromaccountNumber, String toAccountNumber,
			BigDecimal transactionAmount, Timestamp transactionDateTime) {
		super();
		this.transactionId = transactionId;
		this.fromaccountNumber = fromaccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
	}

	public Transaction() {
		super();
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}



	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Timestamp transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
    
}


