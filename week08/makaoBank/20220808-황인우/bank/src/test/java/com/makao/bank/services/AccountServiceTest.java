package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {
  @Test
  void myAccount() {
    AccountRepository accountRepository = new AccountRepository();

    AccountService accountService = new AccountService(accountRepository);

    Account myAccount = accountService.myAccount();

    assertThat(myAccount.identifier()).isEqualTo("110");
    assertThat(myAccount.name()).isEqualTo("버터플");
    assertThat(myAccount.amount()).isEqualTo(1000);
  }
}
