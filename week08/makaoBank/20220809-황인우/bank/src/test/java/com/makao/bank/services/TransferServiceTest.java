package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
  private static final String SENDER_IDENTIFIER = "110";
  private static final String RECEIVER_IDENTIFIER = "179";
  private static final long RECEIVER_INITIAL_AMOUNT = 3000;

  @Test
  void transfer() {
    long transferAmount = 300;

    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account sender = accountRepository.find(SENDER_IDENTIFIER);
    Account receiver = transferService.transfer(
        sender.identifier(), RECEIVER_IDENTIFIER, transferAmount);

    assertThat(receiver.identifier()).isEqualTo(RECEIVER_IDENTIFIER);
    assertThat(receiver.amount())
        .isEqualTo(RECEIVER_INITIAL_AMOUNT + transferAmount);
  }

  @Test
  void transferWithWrongIdentifier() {
    long transferAmount = 300;

    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account sender = accountRepository.find(SENDER_IDENTIFIER);
    Account receiver = transferService.transfer(
        sender.identifier(), "-444421231", transferAmount);

    assertThat(receiver).isNull();
  }
}
