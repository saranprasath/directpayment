package com.currency.exchange.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.currency.exchange.model.Transaction;
import com.currency.exchange.model.User;
import com.currency.exchange.service.UserService;
import com.currency.exchange.web.dto.AccountStatementRequest;
import com.currency.exchange.web.dto.TransferBalanceRequest;
@Controller
@RequestMapping("/transaction")
public class AccountControler {

	@Autowired private UserService accountService;
  

    
    @ModelAttribute("users")
	public TransferBalanceRequest userRegistrationDto() {
		return new TransferBalanceRequest();
	}
   
    @GetMapping
	public String showTranscation() {
		return "transaction";
	}
    @PostMapping
    public String sendMoney(@ModelAttribute("users") TransferBalanceRequest transferBalanceRequest,Model md) {
    	 Transaction transactions=accountService.sendMoney(transferBalanceRequest);
    	 md.addAttribute("transactions",transactions);
    	 if(transactions==null)
        return "redirect:/transaction?error";
    	 return "transactions";
    }
//    @RequestMapping("/statement")
//    public String getStatement(@ModelAttribute("users") AccountStatementRequest accountStatementRequest){
//         accountService.getStatement(accountStatementRequest.getAccountNumber());
//         return "statement";
//
//    }

}

