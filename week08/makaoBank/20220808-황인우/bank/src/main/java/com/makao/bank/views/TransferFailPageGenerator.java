package com.makao.bank.views;

import com.makao.bank.services.TransferService;

public class TransferFailPageGenerator extends PageGenerator {
  private final String status;

  public TransferFailPageGenerator(String status) {
    super();
    this.status = status;
  }

  @Override
  public String content() {
    return switch (status) {
      case (TransferService.INSUFFICIENT_INPUT) -> insufficientInput();
      case (TransferService.INVALID_AMOUNT) -> invalidAmount();
      case (TransferService.ACCOUNT_NOT_FOUND) -> accountNotFound();
      default -> "";
    };
  }

  public String insufficientInput() {
    return "<p>입력하지 않은 내용이 있습니다.</p>\n";
  }

  public String invalidAmount() {
    return "<p>보낼 금액을 확인해 주세요.</p>\n";
  }

  public String accountNotFound() {
    return "<p>계좌 번호를 확인해 주세요.</p>\n";
  }
}
