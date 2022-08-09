package todolist.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("1000021번째 할 일");

    assertThat(task.content()).isEqualTo("1000021번째 할 일");
  }
}
