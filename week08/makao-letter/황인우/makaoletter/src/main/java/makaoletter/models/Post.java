package makaoletter.models;

import java.util.UUID;

public class Post {
  private final String identifier;
  private final String title;
  private final String author;
  private final String content;

  public Post(String title, String author, String content) {
    identifier = UUID.randomUUID().toString();
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public String identifier() {
    return identifier;
  }

  public String title() {
    return title;
  }

  public String author() {
    return author;
  }

  public String content() {
    return content;
  }
}
