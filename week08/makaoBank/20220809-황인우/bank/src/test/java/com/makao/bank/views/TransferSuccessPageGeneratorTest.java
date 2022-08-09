package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferSuccessPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new TransferSuccessPageGenerator();

    String content = pageGenerator.content();

    assertThat(content).contains("계좌 이체 성공!");
  }
}
