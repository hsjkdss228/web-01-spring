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

  @Test
  void transfer() {
    long transferAmount = 400;

    Account sender = new Account("110", "오아리", 1600);
    Account receiver = new Account("110", "오동동", 200);

    sender.transfer(receiver, transferAmount);

    assertThat(sender.amount()).isEqualTo(1600 - transferAmount);
    assertThat(receiver.amount()).isEqualTo(200 + transferAmount);
  }

  @Test
  void invalidTransfer() {
    long transferAmount = -5000000;

    Account sender = new Account("110", "조희팔", 100);
    Account receiver = new Account("110", "황인우", 20000);

    sender.transfer(receiver, transferAmount);

    assertThat(sender.amount()).isEqualTo(100);
    assertThat(receiver.amount()).isEqualTo(20000);
  }
}
