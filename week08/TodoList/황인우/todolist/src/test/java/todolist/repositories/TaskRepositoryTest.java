package todolist.repositories;

import org.junit.jupiter.api.Test;
import todolist.models.Task;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskRepositoryTest {
  @Test
  void addNewTask() {
    TaskRepository taskRepository = new TaskRepository();

    int oldTasksCount = taskRepository.tasksCount();

    assertThat(oldTasksCount).isEqualTo(0);

    taskRepository.addNewTask("새로운 할 일 1");
    taskRepository.addNewTask("새로운 할 일 2");
    taskRepository.addNewTask("새로운 할 일 3");
    taskRepository.addNewTask("새로운 할 일 4");

    int newTasksCount = taskRepository.tasksCount();

    assertThat(newTasksCount).isEqualTo(4);
  }

  @Test
  void blockAddingBlankTask() {
    TaskRepository taskRepository = new TaskRepository();

    int oldTasksCount = taskRepository.tasksCount();

    assertThat(oldTasksCount).isEqualTo(0);

    taskRepository.addNewTask("             ");
    taskRepository.addNewTask(" \t\t");
    taskRepository.addNewTask("  \t   \t");
    taskRepository.addNewTask("\t\t  \t  \t\t");

    int newTasksCount = taskRepository.tasksCount();

    assertThat(newTasksCount).isEqualTo(0);
  }

  @Test
  void tasks() {
    TaskRepository taskRepository = new TaskRepository();

    taskRepository.addNewTask("새로운 할 일 1");
    taskRepository.addNewTask("새로운 할 일 2");
    taskRepository.addNewTask("새로운 할 일 3");
    taskRepository.addNewTask("새로운 할 일 4");

    List<Task> tasks = taskRepository.tasks();

    assertThat(tasks.get(0).content()).isEqualTo("새로운 할 일 1");
    assertThat(tasks.get(1).content()).isEqualTo("새로운 할 일 2");
    assertThat(tasks.get(2).content()).isEqualTo("새로운 할 일 3");
    assertThat(tasks.get(3).content()).isEqualTo("새로운 할 일 4");
  }
}
