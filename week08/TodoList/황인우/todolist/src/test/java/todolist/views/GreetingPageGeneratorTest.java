package todolist.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreetingPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new GreetingPageGenerator();

    String content = pageGenerator.content();

    assertThat(content).contains("Hello, This is Todo List.");
  }
}
