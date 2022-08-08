package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
  public static final String INSUFFICIENT_INPUT = "INSUFFICIENT_INPUT";
  public static final String INVALID_AMOUNT = "INVALID_AMOUNT";
  public static final String ACCOUNT_NOT_FOUND = "ACCOUNT_NOT_FOUND";
  public static final String SUCCESS = "SUCCESS";

  private final AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public String transfer(String identifier, String to, String amount) {
    if (to.isEmpty() || amount.isEmpty()) {
      return TransferService.INSUFFICIENT_INPUT;
    }

    if (Long.parseLong(amount) <= 0) {
      return TransferService.INVALID_AMOUNT;
    }

    Account receiver = accountRepository.find(to);

    if (receiver == null) {
      return TransferService.ACCOUNT_NOT_FOUND;
    }

    Account account = accountRepository.find(identifier);
    account.transfer(receiver, Long.parseLong(amount));

    return TransferService.SUCCESS;
  }
}
