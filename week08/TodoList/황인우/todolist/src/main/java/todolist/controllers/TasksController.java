package todolist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import todolist.models.Task;
import todolist.services.TaskService;
import todolist.views.PageGenerator;
import todolist.views.TasksPageGenerator;

import java.util.List;

@RestController
public class TasksController {
  private final TaskService taskService;

  public TasksController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public String tasksPage() {
    List<Task> tasks = taskService.tasks();

    PageGenerator pageGenerator = new TasksPageGenerator(tasks);
    return pageGenerator.html();
  }

  @PostMapping("/tasks")
  public String tasksPageAfterPuttingTask(
      @RequestParam("task") String newTaskContent
  ) {
    taskService.addNewTask(newTaskContent);

    List<Task> tasks = taskService.tasks();

    PageGenerator pageGenerator = new TasksPageGenerator(tasks);
    return pageGenerator.html();
  }
}
