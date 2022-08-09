package todolist.views;

import org.junit.jupiter.api.Test;
import todolist.models.Task;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TasksPageGeneratorTest {
  @Test
  void content() {
    List<Task> tasks = new ArrayList<>();

    PageGenerator pageGenerator = new TasksPageGenerator(tasks);

    String content = pageGenerator.content();

    assertThat(content).contains("Todo List");
    assertThat(content).contains("할 일");
    assertThat(content).contains("<input type=\"text\"");
    assertThat(content).contains("등록</button>");
  }
}
