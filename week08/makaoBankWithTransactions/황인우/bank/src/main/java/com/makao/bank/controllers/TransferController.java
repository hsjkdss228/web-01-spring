package com.makao.bank.controllers;

import com.makao.bank.models.Account;
import com.makao.bank.services.AccountService;
import com.makao.bank.services.TransferService;
import com.makao.bank.views.PageGenerator;
import com.makao.bank.views.TransferFailPageGenerator;
import com.makao.bank.views.TransferPageGenerator;
import com.makao.bank.views.TransferSuccessPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
  private AccountService accountService;
  private TransferService transferService;

  public TransferController(
      AccountService accountService, TransferService transferService) {
    this.accountService = accountService;
    this.transferService = transferService;
  }

  @GetMapping("/transfer")
  public String transferGet() {
    PageGenerator pageGenerator = new TransferPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/transfer")
  public String transfer(
      @RequestParam("to") String to,
      @RequestParam("amount") String amount
  ) {
    Account myAccount = accountService.myAccount();

    String status
        = transferService.transfer(myAccount.identifier(), to, amount);

    PageGenerator pageGenerator = new TransferSuccessPageGenerator();

    if (!status.equals(TransferService.SUCCESS)) {
      pageGenerator = new TransferFailPageGenerator(status);
    }

    return pageGenerator.html();
  }
}
