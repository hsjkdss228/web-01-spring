package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
  private final AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account transfer(String from, String to, long amount) {
    Account sender = accountRepository.find(from);

    Account receiver = accountRepository.find(to);
    if (receiver == null) {
      return null;
    }

    sender.transfer(receiver, amount);

    return receiver;
  }
}
