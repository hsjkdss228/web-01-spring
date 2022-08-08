package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("110", "한조", 1000);

    assertThat(account.identifier()).isEqualTo("110");
    assertThat(account.name()).isEqualTo("한조");
    assertThat(account.amount()).isEqualTo(1000);
  }
}
