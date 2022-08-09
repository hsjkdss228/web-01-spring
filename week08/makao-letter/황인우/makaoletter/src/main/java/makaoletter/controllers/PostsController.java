package makaoletter.controllers;

import makaoletter.services.PostService;
import makaoletter.views.PageGenerator;
import makaoletter.views.PostsPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PostsController {
  private final PostService postService;

  public PostsController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/posts")
  public String posts() {
    Map<String, List<String>> titleAndAuthors = postService.titleAndAuthors();

    PageGenerator pageGenerator = new PostsPageGenerator(titleAndAuthors);
    return pageGenerator.html();
  }
}
