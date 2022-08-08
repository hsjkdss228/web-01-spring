package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("110", "한조", 1000);

    assertThat(account.identifier()).isEqualTo("110");
    assertThat(account.name()).isEqualTo("한조");
    assertThat(account.amount()).isEqualTo(1000);
  }

  @Test
  void transfer() {
    Account sender = new Account("110", "한조", 1000);
    Account receiver = new Account("110", "솜브라", 200);

    sender.transfer(receiver, 300);

    assertThat(sender.amount()).isEqualTo(700);
    assertThat(receiver.amount()).isEqualTo(500);
  }

  @Test
  void invalidTransfer() {
    Account sender = new Account("110", "한조", 1000);
    Account receiver = new Account("110", "솜브라", 200);

    sender.transfer(receiver, -5000);

    assertThat(sender.amount()).isEqualTo(1000);
    assertThat(receiver.amount()).isEqualTo(200);
  }
}
