package com.makao.bank.controllers;

import com.makao.bank.views.PageGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  @GetMapping("/account")
  public String account() {
    PageGenerator pageGenerator = new AccountPageGenerator();
    return pageGenerator.content();
  }
}
