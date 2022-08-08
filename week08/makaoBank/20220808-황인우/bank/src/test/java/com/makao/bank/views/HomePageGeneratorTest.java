package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HomePageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new HomePageGenerator();

    String content = pageGenerator.content();

    assertThat(content).contains("Hello, world!");
  }
}
