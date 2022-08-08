package com.makao.bank.views;

import com.makao.bank.models.Account;

public class AccountPageGenerator extends PageGenerator {
  private final Account account;

  public AccountPageGenerator(Account account) {
    this.account = account;
  }

  @Override
  public String content() {
    return "<p>계좌번호: " + account.identifier() + "</p>\n" +
        "<p>잔액: " + account.amount() + "원</p>\n";
  }
}
