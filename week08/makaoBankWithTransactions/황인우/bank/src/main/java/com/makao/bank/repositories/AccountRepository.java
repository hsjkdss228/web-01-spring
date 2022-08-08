package com.makao.bank.repositories;

import com.makao.bank.models.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class AccountRepository {
  private final Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    reset();
  }

  public void reset() {
    Stream.of(
        new Account("110", "버터플", 1000),
        new Account("179", "야도란", 200)
    ).forEach(account -> {
      accounts.put(account.identifier(), account);
    });
  }

  public Account find(String identifier) {
    if (!accounts.containsKey(identifier)) {
      return null;
    }

    return accounts.get(identifier);
  }
}
