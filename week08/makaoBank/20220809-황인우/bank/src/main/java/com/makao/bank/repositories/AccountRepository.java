package com.makao.bank.repositories;

import com.makao.bank.models.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("110", "아구몬", 1000),
        new Account("179", "파피몬", 3000),
        new Account("352", "텐타몬", 700)
    ).forEach(account -> {
      accounts.put(account.identifier(), account);
    });
  }

  public Account find(String identifier) {
    if (accounts.containsKey(identifier)) {
      return accounts.get(identifier);
    }

    return null;
  }
}
