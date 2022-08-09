package com.makao.bank.views;

public class TransferPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method=\"POST\">\n" +
        "<p>\n" +
        "<label>받는 사람 계좌: \n" +
        "<input type=\"text\" name=\"to\" />\n" +
        "</label>\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>보낼 금액: \n" +
        "<input type=\"number\" name=\"amount\" />\n" +
        "</label>\n" +
        "</p>\n" +
        "<button type=\"submit\">확인</button>\n" +
        "</form>\n";
  }
}
