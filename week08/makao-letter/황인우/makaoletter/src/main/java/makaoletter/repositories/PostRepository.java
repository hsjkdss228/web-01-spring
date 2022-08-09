package makaoletter.repositories;

import makaoletter.models.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {
  public static final int TITLE_INDEX = 0;
  public static final int AUTHOR_INDEX = 1;

  private final Map<String, List<Post>> posts = new HashMap<>();
  private final Map<String, List<String>> titleAndAuthors = new LinkedHashMap<>();

  public Map<String, List<Post>> posts() {
    return new HashMap<>(posts);
  }

  public Map<String, List<String>> titleAndAuthors() {
    return new LinkedHashMap<>(titleAndAuthors);
  }

  public void addNewPost(String title, String author, String content) {
    Post post = new Post(title, author, content);

    if (posts.containsKey(author)) {
      posts.get(author).add(post);
    }

    if (!posts.containsKey(author)) {
      List<Post> postsWrittenByAuthor = new ArrayList<>();
      postsWrittenByAuthor.add(post);

      posts.put(author, postsWrittenByAuthor);
    }

    String identifier = post.identifier();

    List<String> titleAndAuthor = new ArrayList<>();
    titleAndAuthor.add(title);
    titleAndAuthor.add(author);

    titleAndAuthors.put(identifier, titleAndAuthor);
  }
}
