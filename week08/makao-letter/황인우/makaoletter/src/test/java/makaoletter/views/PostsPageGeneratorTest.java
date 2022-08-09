package makaoletter.views;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PostsPageGeneratorTest {
  @Test
  void content() {
    Map<String, List<String>> titleAndAuthors = new HashMap<>();

    PageGenerator pageGenerator = new PostsPageGenerator(titleAndAuthors);

    String content = pageGenerator.content();

    assertThat(content).contains("저자");
    assertThat(content).contains("input type=\"text\" name=\"author\"");
    assertThat(content).contains("찾기");
  }
}
