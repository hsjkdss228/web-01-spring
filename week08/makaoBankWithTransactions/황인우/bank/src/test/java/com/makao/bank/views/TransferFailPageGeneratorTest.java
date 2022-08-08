package com.makao.bank.views;

import com.makao.bank.services.TransferService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferFailPageGeneratorTest {
  @Test
  void insufficientInput() {
    PageGenerator pageGenerator
        = new TransferFailPageGenerator(TransferService.INSUFFICIENT_INPUT);

    String content = pageGenerator.content();

    assertThat(content).contains("입력하지 않은 내용이 있습니다.");
  }

  @Test
  void invalidAmount() {
    PageGenerator pageGenerator
        = new TransferFailPageGenerator(TransferService.INVALID_AMOUNT);

    String content = pageGenerator.content();

    assertThat(content).contains("보낼 금액을 확인해 주세요.");
  }

  @Test
  void accountNotFound() {
    PageGenerator pageGenerator
        = new TransferFailPageGenerator(TransferService.ACCOUNT_NOT_FOUND);

    String content = pageGenerator.content();

    assertThat(content).contains("계좌 번호를 확인해 주세요.");
  }
}
