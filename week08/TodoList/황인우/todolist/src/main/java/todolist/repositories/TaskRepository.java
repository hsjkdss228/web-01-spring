package todolist.repositories;

import org.springframework.stereotype.Repository;
import todolist.models.Task;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
  private final List<Task> tasks;

  public TaskRepository() {
    tasks = new ArrayList<>();
  }

  public List<Task> tasks() {
    return new ArrayList<>(tasks);
  }

  public int tasksCount() {
    return tasks.size();
  }

  public void addNewTask(String content) {
    if (content.isBlank()) {
      return;
    }

    Task task = new Task(content);

    tasks.add(task);
  }
}
