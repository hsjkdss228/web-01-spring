package com.makao.bank.repositories;

import com.makao.bank.models.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("1234", "ashal", 3000)
    ).forEach(account -> accounts.put(account.identifier(),account));
  }

  public Account find(String identifier) {
    if (!accounts.containsKey(identifier)) {
      return null;
    }

    Account account = accounts.get(identifier);

    return account;
  }
}
