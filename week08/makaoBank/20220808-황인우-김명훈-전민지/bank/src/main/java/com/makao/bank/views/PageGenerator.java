package com.makao.bank.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html lang=\"ko\">\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>마카오 뱅크</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<nav>\n" +
        "<a href=\"/\">Home</a>\n" +
        "<a href=\"/account\">잔액 조회</a>\n" +
        "</nav>" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public abstract String content();
}
