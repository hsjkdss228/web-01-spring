package makaoletter.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\" />\n" +
        "<title>Makao Letter</title>\n" +
        styles() +
        "</head>\n" +
        "<body>\n" +
        "<h1>Makao Letter</h1>\n" +
        navigation() +
        content() +
        "</body>\n" +
        "</html>\n";
  }

  public String styles() {
    return "<style>\n" +
        "nav a {\n" +
        "padding-right: 10px;\n" +
        "}\n" +
        "#register-post input, #register-post textarea {\n" +
        "display: block;\n" +
        "}\n" +
        "</style>\n";
  }

  public String navigation() {
    return "<nav>\n" +
        "<a href=\"/posts\">글 목록보기</a>\n" +
        "<a href=\"/post\">새 글 등록하기</a>\n" +
        "</nav>\n";
  }

  public abstract String content();
}
