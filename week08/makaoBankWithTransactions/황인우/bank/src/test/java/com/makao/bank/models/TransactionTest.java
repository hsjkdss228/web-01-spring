package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {
  @Test
  void creation() {
    long transferredAmount = 200;

    Account sender = new Account("110", "센더", 500);
    Account receiver = new Account("179", "리시버", 1200);

    Transaction transaction
        = new Transaction(sender, receiver, transferredAmount);

    assertThat(transaction.sender()).isEqualTo(sender);
    assertThat(transaction.receiver()).isEqualTo(receiver);
    assertThat(transaction.amount()).isEqualTo(transferredAmount);
  }

  @Test
  void command() {
    long transferredAmount = 200;

    Account sender = new Account("110", "센더", 500);
    Account receiver = new Account("179", "리시버", 1200);

    Transaction transaction
        = new Transaction(sender, receiver, transferredAmount);

    assertThat(transaction.command(sender)).isEqualTo("송금");
    assertThat(transaction.command(receiver)).isEqualTo("입금");
  }

  @Test
  void other() {
    long transferredAmount = 200;

    Account sender = new Account("110", "센더", 500);
    Account receiver = new Account("179", "리시버", 1200);

    Transaction transaction
        = new Transaction(sender, receiver, transferredAmount);

    assertThat(transaction.other(sender)).isEqualTo("리시버");
    assertThat(transaction.other(receiver)).isEqualTo("센더");
  }
}
