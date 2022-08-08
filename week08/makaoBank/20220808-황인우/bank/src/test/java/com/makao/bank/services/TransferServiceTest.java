package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
  private static final String MY_IDENTIFIER = "110";
  private static final String RECEIVER_IDENTIFIER = "179";

  @Test
  void transferSuccess() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account account = accountRepository.find(MY_IDENTIFIER);

    String status
        = transferService.transfer(account.identifier(), RECEIVER_IDENTIFIER, "300");

    assertThat(status).isEqualTo(TransferService.SUCCESS);
  }

  @Test
  void transferWithoutTo() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account account = accountRepository.find(MY_IDENTIFIER);

    String status
        = transferService.transfer(account.identifier(), "", "300");

    assertThat(status).isEqualTo(TransferService.INSUFFICIENT_INPUT);
  }

  @Test
  void transferWithoutAmount() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account account = accountRepository.find(MY_IDENTIFIER);

    String status
        = transferService.transfer(account.identifier(), RECEIVER_IDENTIFIER, "");

    assertThat(status).isEqualTo(TransferService.INSUFFICIENT_INPUT);
  }

  @Test
  void transferWithInvalidAmount() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account account = accountRepository.find(MY_IDENTIFIER);

    String status
        = transferService.transfer(account.identifier(), RECEIVER_IDENTIFIER, "-20000");

    assertThat(status).isEqualTo(TransferService.INVALID_AMOUNT);
  }

  @Test
  void transferWithInvalidIdentifier() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account account = accountRepository.find(MY_IDENTIFIER);

    String status
        = transferService.transfer(account.identifier(), "44444444", "300");

    assertThat(status).isEqualTo(TransferService.ACCOUNT_NOT_FOUND);
  }
}
