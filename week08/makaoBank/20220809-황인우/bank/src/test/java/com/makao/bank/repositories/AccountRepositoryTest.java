package com.makao.bank.repositories;

import com.makao.bank.models.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("179");

    assertThat(account.identifier()).isEqualTo("179");
    assertThat(account.name()).isEqualTo("파피몬");
    assertThat(account.amount()).isEqualTo(3000);
  }

  @Test
  void notFound() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("565656666");

    assertThat(account).isNull();
  }
}
