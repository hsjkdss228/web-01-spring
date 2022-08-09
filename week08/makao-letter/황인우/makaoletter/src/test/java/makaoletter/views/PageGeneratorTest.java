package makaoletter.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "";
      }
    };

    String navigation = pageGenerator.navigation();

    assertThat(navigation).contains("글 목록보기");
    assertThat(navigation).contains("새 글 등록하기");
  }
}
