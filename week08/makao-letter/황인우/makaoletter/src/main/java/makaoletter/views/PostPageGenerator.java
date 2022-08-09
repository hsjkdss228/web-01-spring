package makaoletter.views;

public class PostPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form id=\"register-post\" method=\"POST\">\n" +
        "<p>\n" +
        "<label>제목\n" +
        "<input type=\"text\" name=\"title\" size=\"37\" />\n" +
        "</label>\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>저자\n" +
        "<input type=\"text\" name=\"author\" size=\"37\" />\n" +
        "</label>\n" +
        "</p>\n" +
        "<p>\n" +
        "<label>내용\n" +
        "<textarea name=\"content\" rows=\"5\" cols=\"30\"></textarea>\n" +
        "</label>\n" +
        "</p>\n" +
        "<button type=\"submit\">등록하기</button>\n" +
        "</form>\n";
  }
}
