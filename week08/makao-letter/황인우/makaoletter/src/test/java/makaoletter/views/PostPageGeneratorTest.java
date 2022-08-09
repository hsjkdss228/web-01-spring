package makaoletter.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new PostPageGenerator();

    String content = pageGenerator.content();

    assertThat(content).contains("제목");
    assertThat(content).contains("input type=\"text\" name=\"title\"");
    assertThat(content).contains("저자");
    assertThat(content).contains("input type=\"text\" name=\"author\"");
    assertThat(content).contains("내용");
    assertThat(content).contains("textarea name=\"content\"");
    assertThat(content).contains("등록하기</button>");
  }
}
