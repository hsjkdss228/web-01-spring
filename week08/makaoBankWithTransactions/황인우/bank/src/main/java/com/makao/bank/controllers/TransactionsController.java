package com.makao.bank.controllers;

import com.makao.bank.models.Account;
import com.makao.bank.services.AccountService;
import com.makao.bank.views.PageGenerator;
import com.makao.bank.views.TransactionsPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {
  private final AccountService accountService;

  public TransactionsController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/transactions")
  public String transactions() {
    Account account = accountService.myAccount();

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);
    return pageGenerator.html();
  }
}
