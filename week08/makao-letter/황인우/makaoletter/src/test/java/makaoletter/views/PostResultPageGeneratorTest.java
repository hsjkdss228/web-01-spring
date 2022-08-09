package makaoletter.views;

import makaoletter.services.PostService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostResultPageGeneratorTest {
  @Test
  void accepted() {
    PageGenerator pageGenerator
        = new PostResultPageGenerator(PostService.ACCEPTED);

    String content = pageGenerator.content();

    assertThat(content).contains("등록이 완료되었습니다.");
  }

  @Test
  void insufficient() {
    PageGenerator pageGenerator
        = new PostResultPageGenerator(PostService.INSUFFICIENT);

    String content = pageGenerator.content();

    assertThat(content).contains("입력되지 않은 내용이 있습니다.");
  }
}
