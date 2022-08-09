package todolist.models;

import java.util.UUID;

public class Task {
  private final String identifier;
  private final String content;

  public Task(String content) {
    identifier = UUID.randomUUID().toString();
    this.content = content;
  }

  public String identifier() {
    return identifier;
  }

  public String content() {
    return content;
  }
}
