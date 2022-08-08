package com.makao.bank.views;

import com.makao.bank.models.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionsPageGeneratorTest {
  @Test
  void contentWithNoTransactions() {
    Account account = new Account("110", "치코리타", 1000);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String content = pageGenerator.content();

    assertThat(content).contains("거래 내역");
  }

  @Test
  void contentWithTransactions() {
    Account account = new Account("110", "로사", 1000);
    Account receiver = new Account("179", "마자용", 500);

    account.transfer(receiver, 20);
    account.transfer(receiver, 70);
    receiver.transfer(account, 150);

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);

    String content = pageGenerator.content();

    assertThat(content).contains("거래 내역");
    assertThat(content).contains("송금: 마자용 20원");
    assertThat(content).contains("송금: 마자용 70원");
    assertThat(content).contains("입금: 마자용 150원");

    pageGenerator = new TransactionsPageGenerator(receiver);

    content = pageGenerator.content();

    assertThat(content).contains("거래 내역");
    assertThat(content).contains("입금: 로사 20원");
    assertThat(content).contains("입금: 로사 70원");
    assertThat(content).contains("송금: 로사 150원");
  }
}
