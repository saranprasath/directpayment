package com.currency.exchange.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.currency.exchange.model.CurrencyRates;
import com.currency.exchange.model.Transaction;
import com.currency.exchange.model.User;
import com.currency.exchange.web.dto.AccountStatement;
import com.currency.exchange.web.dto.CurrencyRate;
import com.currency.exchange.web.dto.TransferBalanceRequest;
import com.currency.exchange.web.dto.UserRegistration;


public interface UserService extends UserDetailsService {
  User save(UserRegistration registrationDto);
  CurrencyRates save(CurrencyRate registrationDto);
  List<CurrencyRates> findAll();
  List<Transaction> findAlltransaction(String Accno);
  Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);
  AccountStatement getStatement(String accountNumber);
BigDecimal exchange(String baseCurrency, String toCurrency, BigDecimal amount);
}
