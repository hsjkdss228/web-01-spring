package makaoletter.services;

import makaoletter.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostService {
  public static final String INSUFFICIENT = "INSUFFICIENT";
  public static final String ACCEPTED = "ACCEPTED";

  private final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public String addNewPost(String title, String author, String content) {
    if (title.isBlank() || author.isBlank() || content.isBlank()) {
      return PostService.INSUFFICIENT;
    }

    postRepository.addNewPost(title, author, content);

    return PostService.ACCEPTED;
  }

  public Map<String, List<String>> titleAndAuthors() {
    return postRepository.titleAndAuthors();
  }
}
