package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new TransferPageGenerator();

    String content = pageGenerator.content();

    assertThat(content).contains("받는 사람 계좌: <input");
    assertThat(content).contains("보낼 금액: <input");
    assertThat(content).contains("확인</button>");
  }
}
