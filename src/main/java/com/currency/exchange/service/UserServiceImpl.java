package com.currency.exchange.service;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.currency.exchange.model.CurrencyRates;
import com.currency.exchange.model.Role;
import com.currency.exchange.model.Transaction;
import com.currency.exchange.model.User;
import com.currency.exchange.repository.ExchangeRepo;
import com.currency.exchange.repository.TransactionRepository;
import com.currency.exchange.repository.Userrepository;
import com.currency.exchange.web.dto.AccountStatement;
import com.currency.exchange.web.dto.CurrencyRate;
import com.currency.exchange.web.dto.TransferBalanceRequest;
import com.currency.exchange.web.dto.UserRegistration;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private Userrepository userRepository;
	@Autowired
	ExchangeRepo exchangerepo;
	@Autowired
	private TransactionRepository transrepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
    TransactionRepository transactionRepository;
	public UserServiceImpl(Userrepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistration registrationDto) {
		User user=new User(registrationDto.getUsername(),registrationDto.getEmail(),passwordEncoder.encode(registrationDto.getPassword()),registrationDto.getAccount_no(),registrationDto.getCurrencytype(),registrationDto.getCurrentBalance(),Arrays.asList(new Role("ROLE_USER")));
	return userRepository.save(user);
	}
	
	
	@Override
	public CurrencyRates save(CurrencyRate registrationDto)
	{
		CurrencyRates rates=new CurrencyRates(registrationDto.getBaseCurrency(),registrationDto.getTargetCurrency(),registrationDto.getMultipleAmount());
		return exchangerepo.save(rates);
	}
	
	
	
	@Override
    public List<Transaction> findAlltransaction(String Accno) {

        return (List<Transaction>) transrepo.findByfromaccountNumberEquals(Accno);
    }
	
	
	public List<CurrencyRates> findAll(){
        return exchangerepo.findAll();
    }
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles){
		return 	roles.stream().map(role-> new SimpleGrantedAuthority(role.getUsername())).collect(Collectors.toList());
		}
	
	
	
	
    public User findByAccountNumber(String accountNumber){
        User account = userRepository.findByAccnoEquals(accountNumber);
        return account;
    }
    
    
    
    
    @Override
    public BigDecimal exchange(String from,String to,BigDecimal amount)
    {
    	List<CurrencyRates> rate1=exchangerepo.findAll();
    	if(from.compareTo("INR")!=0 && to.compareTo("INR")!=0)
    	{
    		for(CurrencyRates rate:rate1)
    		{
    			if(rate.getBaseCurrency().compareTo(from)==0 && rate.getTargetCurrency().compareTo("INR")==0)
    			{
    				amount=amount.multiply(rate.getMultipleAmount());
    				from="INR";
    				break;
    			}
    		}
    	}
    	for(CurrencyRates rate:rate1)
    	{
    		if(rate.getBaseCurrency().compareTo(from)==0 && rate.getTargetCurrency().compareTo(to)==0)
    		{
    			amount=amount.multiply(rate.getMultipleAmount());
    			break;
    		}
    	}
    	return amount;
    }
    
    
    
    
    @Override
    public Transaction sendMoney(TransferBalanceRequest transferBalanceRequest) throws NullPointerException {
        String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
        String toAccountNumber = transferBalanceRequest.getToAccountNumber();
        BigDecimal amount = transferBalanceRequest.getAmount();
        User fromAccount = userRepository.findByAccnoEquals(fromAccountNumber);
        User toAccount = userRepository.findByAccnoEquals(toAccountNumber);
        if(fromAccount==null || toAccount==null)
        	throw new NullPointerException("Invalid Details");
        if(fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
                && fromAccount.getCurrentBalance().compareTo(amount) == 1
        ){
        	
            fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
            userRepository.save(fromAccount);
            Transaction transaction = transactionRepository.save(new Transaction(0L,fromAccountNumber,toAccountNumber,amount,new Timestamp(System.currentTimeMillis())));
            
            if(transferBalanceRequest.getBaseCurrency().compareTo(transferBalanceRequest.getToCurrency())!=0)
            	amount=exchange(transferBalanceRequest.getBaseCurrency(),transferBalanceRequest.getToCurrency(),transferBalanceRequest.getAmount());
            toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
            userRepository.save(toAccount);
            return transaction;
        }
        return null;
    }

    
    
    @Override
    public AccountStatement getStatement(String accountNumber) {
        User account = userRepository.findByAccnoEquals(accountNumber);
        return new AccountStatement(account.getCurrentBalance(),transactionRepository.findByfromaccountNumberEquals(accountNumber));
    }

	
}
