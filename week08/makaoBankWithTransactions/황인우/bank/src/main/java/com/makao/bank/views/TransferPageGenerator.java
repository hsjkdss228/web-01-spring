package com.makao.bank.views;

public class TransferPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method=\"POST\">\n" +
        "<p>" +
        "<label>받는 사람 계좌: <input type=\"text\" name=\"to\" /></label>\n" +
        "</p>" +
        "<p>" +
        "<label>보낼 금액: <input type=\"number\" name=\"amount\" /></label>\n" +
        "</p>" +
        "<button type=\"submit\">확인</button>\n" +
        "</form>\n";
  }
}
