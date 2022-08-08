package com.makao.bank.views;

import com.makao.bank.models.Account;

import java.util.stream.Collectors;

public class TransactionsPageGenerator extends PageGenerator {
  private final Account account;

  public TransactionsPageGenerator(Account account) {
    super();
    this.account = account;
  }

  @Override
  public String content() {
    return "<h1>거래 내역</h1>\n" +
        "<ul>\n" +
        account.transactions().stream()
            .map(transaction ->
                "<li>" + transaction.command(account) + ": " +
                    transaction.other(account) + " " +
                    transaction.amount() + "원</li>\n")
            .collect(Collectors.joining()) +
        "</ul>\n";
  }
}
