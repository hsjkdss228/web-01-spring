package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "ashal", 3000);

    assertThat(account.identifier()).isEqualTo("1234");
    assertThat(account.name()).isEqualTo("ashal");
    assertThat(account.amount()).isEqualTo(3000);
  }
}
