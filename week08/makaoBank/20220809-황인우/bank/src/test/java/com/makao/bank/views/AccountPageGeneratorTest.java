package com.makao.bank.views;

import com.makao.bank.models.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("110", "아구몬", 1000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String content = pageGenerator.content();

    assertThat(content).contains("계좌 번호: ");
    assertThat(content).contains("잔액: ");
  }
}
