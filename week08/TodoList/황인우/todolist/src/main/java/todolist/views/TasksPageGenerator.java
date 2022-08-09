package todolist.views;

import todolist.models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TasksPageGenerator extends PageGenerator {
  private final List<Task> tasks;

  public TasksPageGenerator(List<Task> tasks) {
    super();
    this.tasks = tasks;
  }

  @Override
  public String content() {
    return "<h2>Todo List</h2>\n" +
        "<form method=\"POST\">\n" +
        "<label>할 일:  \n" +
        "<input type=\"text\" name=\"task\" />\n" +
        "</label>\n" +
        "<button type=\"submit\">등록</button>\n" +
        "</form>\n" +
        "<ul>\n" +
        showTasks() +
        "</ul>\n";
  }

  public String showTasks() {
    return tasks.stream()
        .map(task -> "<li>" + task.content() + "</li>\n")
        .collect(Collectors.joining());
  }
}
