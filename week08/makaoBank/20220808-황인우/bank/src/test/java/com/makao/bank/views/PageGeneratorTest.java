package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "";
      }
    };

    String navigation = pageGenerator.navigation();

    assertThat(navigation).contains("Home");
    assertThat(navigation).contains("잔액 조회");
    assertThat(navigation).contains("계좌 이체");
  }
}
