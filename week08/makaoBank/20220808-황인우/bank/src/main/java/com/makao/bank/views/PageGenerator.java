package com.makao.bank.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\" />\n" +
        "<title>Makao Bank</title>\n" +
        style() +
        "</head>\n" +
        "<body>\n" +
        navigation() +
        content() +
        "</body>\n" +
        "</html>";
  }

  public String style() {
    return "<style>\n" +
        "label {\n" +
        "display: block;\n" +
        "}\n" +
        "</style>\n";
  }

  public String navigation() {
    return "<a href=\"/\">Home</a> \n" +
        "<a href=\"/account\">잔액 조회</a> \n" +
        "<a href=\"/transfer\">계좌 이체</a> \n";
  }

  public abstract String content();
}
