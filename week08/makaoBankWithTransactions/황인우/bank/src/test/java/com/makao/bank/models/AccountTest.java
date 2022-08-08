package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

  @Test
  void transactions() {
    Account sender = new Account("110", "시메트라", 1000);
    Account receiver = new Account("110", "토르비욘", 200);

    sender.transfer(receiver, 20);
    sender.transfer(receiver, 50);
    sender.transfer(receiver, -30);
    sender.transfer(receiver, 100);
    sender.transfer(receiver, 40);

    List<Transaction> senderTransactions = sender.transactions();

    assertThat(senderTransactions.get(0).amount()).isEqualTo(20);
    assertThat(senderTransactions.get(1).amount()).isEqualTo(50);
    assertThat(senderTransactions.get(2).amount()).isEqualTo(100);
    assertThat(senderTransactions.get(3).amount()).isEqualTo(40);

    List<Transaction> receiverTransactions = receiver.transactions();

    assertThat(receiverTransactions.get(0).amount()).isEqualTo(20);
    assertThat(receiverTransactions.get(1).amount()).isEqualTo(50);
    assertThat(receiverTransactions.get(2).amount()).isEqualTo(100);
    assertThat(receiverTransactions.get(3).amount()).isEqualTo(40);
  }

  @Test
  void transactionsCount() {
    Account sender = new Account("110", "시메트라", 1000);
    Account receiver = new Account("110", "토르비욘", 200);

    int oldSenderTransactionsCount = sender.transactionsCount();
    int oldReceiverTransactionsCount = receiver.transactionsCount();

    sender.transfer(receiver, 20);
    sender.transfer(receiver, 50);
    sender.transfer(receiver, -30);
    sender.transfer(receiver, 100);
    sender.transfer(receiver, 40);

    int newSenderTransactionsCount = sender.transactionsCount();
    int newReceiverTransactionsCount = receiver.transactionsCount();

    assertThat(newSenderTransactionsCount - oldSenderTransactionsCount)
        .isEqualTo(4);
    assertThat(newReceiverTransactionsCount - oldReceiverTransactionsCount)
        .isEqualTo(4);
  }

  @Test
  void equals() {
    Account account1 = new Account("110", "위도우메이커", 1000);
    Account account2 = new Account("110", "위도우메이커", 1000);

    assertEquals(account1, account2);
  }
}
