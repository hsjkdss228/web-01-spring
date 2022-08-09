package makaoletter.views;

import makaoletter.services.PostService;

public class PostResultPageGenerator extends PageGenerator {
  private final String status;

  public PostResultPageGenerator(String status) {
    super();
    this.status = status;
  }

  @Override
  public String content() {
    if (status.equals(PostService.ACCEPTED)) {
      return accepted();
    }

    return insufficient();
  }

  public String accepted() {
    return "<p>등록이 완료되었습니다.</p>\n";
  }

  public String insufficient() {
    return "<p>입력되지 않은 내용이 있습니다.</p>\n";
  }
}
