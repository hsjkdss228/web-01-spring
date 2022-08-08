package com.makao.bank.views;

import com.makao.bank.models.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("110", "버터플", 1000);

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String content = pageGenerator.content();

    assertThat(content).contains("계좌번호: 110");
    assertThat(content).contains("잔액: 1000원");
  }
}
