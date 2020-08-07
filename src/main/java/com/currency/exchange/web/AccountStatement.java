package com.currency.exchange.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.currency.exchange.model.Transaction;
import com.currency.exchange.service.UserService;
import com.currency.exchange.web.dto.AccountStatementRequest;
import com.currency.exchange.web.dto.TransferBalanceRequest;
@Controller
public class AccountStatement {
	@Autowired
    private UserService userService;
     @GetMapping("/SeeTransactionget")
     public String ShowSeeTransactionget()
     {
    	 return "SeeTransactionget";
     }
     @ModelAttribute("usersaccno")
 	public AccountStatementRequest userRegistrationDto() {
 		return new AccountStatementRequest();
 	}
	 @PostMapping("/transactions")
	    public String index(@ModelAttribute("useraccno") AccountStatementRequest accono,Model md){
		 List<Transaction> tran=userService.findAlltransaction(accono.getAccountNumber());
		 if(accono.getTransactionId()!=null)
		 {
			 for(Transaction trans:tran)
			 {
				 if(trans.getTransactionId()==accono.getTransactionId())
				 {
					 md.addAttribute("transactions",trans);
					 break;
				 }
			 }
		 }
		 else
	        md.addAttribute("transactions",tran);

	        return "transactions";
	    }

}
