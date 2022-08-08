package com.makao.bank.models;

public class Transaction {
  private Account sender;
  private Account receiver;
  private long amount;

  public Transaction(Account sender, Account receiver, long amount) {
    this.sender = sender;
    this.receiver = receiver;
    this.amount = amount;
  }

  public Account sender() {
    return sender;
  }

  public Account receiver() {
    return receiver;
  }

  public long amount() {
    return amount;
  }

  public String command(Account account) {
    return account == sender
        ? "송금"
        : "입금";
  }

  public String other(Account account) {
    return account == sender
        ? receiver.name()
        : sender.name();
  }
}
