package com.currency.exchange.web.dto;

public class AccountStatementRequest {
	    private String accountNumber;
        private Long TransactionId;
		public Long getTransactionId() {
			return TransactionId;
		}

		public void setTransactionId(Long transactionId) {
			TransactionId = transactionId;
		}

		
		public AccountStatementRequest(String accountNumber) {
			super();
			this.accountNumber = accountNumber;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public AccountStatementRequest() {
			super();
		}

	
}
