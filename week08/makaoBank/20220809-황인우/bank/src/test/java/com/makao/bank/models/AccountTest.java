package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("110", "아구몬", 1000);

    assertThat(account.identifier()).isEqualTo("110");
    assertThat(account.name()).isEqualTo("아구몬");
    assertThat(account.amount()).isEqualTo(1000);
  }
}
