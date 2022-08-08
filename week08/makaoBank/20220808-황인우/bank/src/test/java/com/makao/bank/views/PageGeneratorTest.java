package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "<p>ㅋ</p\n";
      }
    };

    String navigation = pageGenerator.navigation();

    assertThat(navigation).contains("Home");
    assertThat(navigation).contains("잔액 조회");
  }
}
