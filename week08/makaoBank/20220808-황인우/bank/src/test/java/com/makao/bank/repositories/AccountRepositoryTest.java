package com.makao.bank.repositories;

import com.makao.bank.models.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("110");

    assertThat(account.identifier()).isEqualTo("110");
    assertThat(account.name()).isEqualTo("버터플");
    assertThat(account.amount()).isEqualTo(1000);
  }

  @Test
  void notFound() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("4444444");

    assertThat(account).isNull();
  }
}
