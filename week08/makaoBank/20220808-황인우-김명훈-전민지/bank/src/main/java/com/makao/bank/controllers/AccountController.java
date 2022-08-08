package com.makao.bank.controllers;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import com.makao.bank.views.AccountPageGenerator;
import com.makao.bank.views.PageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  private AccountRepository accountRepository;

  public AccountController() {
    this.accountRepository = new AccountRepository();
  }

  @GetMapping("/account")
  public String account() {
    Account account = accountRepository.find("1234");

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    return pageGenerator.html();
  }
}
