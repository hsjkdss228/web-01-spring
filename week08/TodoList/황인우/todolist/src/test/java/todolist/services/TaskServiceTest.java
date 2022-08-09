package todolist.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todolist.models.Task;
import todolist.repositories.TaskRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskServiceTest {
  private TaskRepository taskRepository;
  private TaskService taskService;

  @BeforeEach
  void initialization() {
    taskRepository = new TaskRepository();
    taskService = new TaskService(taskRepository);
  }

  @Test
  void addNewTask() {
    taskService.addNewTask("새로운 할 일 1");
    taskService.addNewTask("새로운 할 일 2");
    taskService.addNewTask("새로운 할 일 3");
    taskService.addNewTask("새로운 할 일 4");

    List<Task> tasks = taskService.tasks();

    assertThat(tasks.get(0).content()).isEqualTo("새로운 할 일 1");
    assertThat(tasks.get(1).content()).isEqualTo("새로운 할 일 2");
    assertThat(tasks.get(2).content()).isEqualTo("새로운 할 일 3");
    assertThat(tasks.get(3).content()).isEqualTo("새로운 할 일 4");
  }

  @Test
  void blockAddingBlankTask() {
    taskService.addNewTask("             ");
    taskService.addNewTask(" \t\t");
    taskService.addNewTask("  \t   \t");
    taskService.addNewTask("\t\t  \t  \t\t");

    List<Task> tasks = taskService.tasks();

    assertThat(tasks.isEmpty()).isTrue();
  }
}