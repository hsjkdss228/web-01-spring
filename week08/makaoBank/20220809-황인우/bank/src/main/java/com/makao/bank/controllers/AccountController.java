package com.makao.bank.controllers;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import com.makao.bank.views.AccountPageGenerator;
import com.makao.bank.views.PageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  private final AccountRepository accountRepository;

  public AccountController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/account")
  public String account() {
    Account myAccount = accountRepository.find("110");

    PageGenerator pageGenerator = new AccountPageGenerator(myAccount);
    return pageGenerator.html();
  }
}
