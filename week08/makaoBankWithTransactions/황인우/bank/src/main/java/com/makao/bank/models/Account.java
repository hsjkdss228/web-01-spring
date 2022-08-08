package com.makao.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String identifier;
  private final String name;
  private long amount;

  private final List<Transaction> transactions = new ArrayList<>();

  public Account(String identifier, String name, long amount) {
    this.identifier = identifier;
    this.name = name;
    this.amount = amount;
  }

  public String identifier() {
    return identifier;
  }

  public String name() {
    return name;
  }

  public long amount() {
    return amount;
  }

  public List<Transaction> transactions() {
    return new ArrayList<>(transactions);
  }

  public int transactionsCount() {
    return transactions.size();
  }

  public void transfer(Account receiver, long amount) {
    if (amount <= 0) {
      return;
    }

    this.amount -= amount;
    receiver.amount += amount;

    Transaction transaction = new Transaction(this, receiver, amount);

    transactions.add(transaction);
    receiver.transactions.add(transaction);
  }

  @Override
  public boolean equals(Object other) {
    Account otherAccount = (Account) other;

    return this.identifier().equals(otherAccount.identifier());
  }
}
