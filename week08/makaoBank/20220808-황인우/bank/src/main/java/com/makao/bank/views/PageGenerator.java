package com.makao.bank.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\" />\n" +
        "<title>Makao Bank</title>\n" +
        "</head>\n" +
        "<body>\n" +
        navigation() +
        content() +
        "</body>\n" +
        "</html>";
  }

  public String navigation() {
    return "<a href=\"/\">Home</a> \n" +
        "<a href=\"/account\">잔액 조회</a> \n";
  }

  public abstract String content();
}
