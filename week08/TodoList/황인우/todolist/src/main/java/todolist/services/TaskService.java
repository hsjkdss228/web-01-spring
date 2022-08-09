package todolist.services;

import org.springframework.stereotype.Service;
import todolist.models.Task;
import todolist.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void addNewTask(String newTaskContent) {
    taskRepository.addNewTask(newTaskContent);
  }

  public List<Task> tasks() {
    return taskRepository.tasks();
  }
}
