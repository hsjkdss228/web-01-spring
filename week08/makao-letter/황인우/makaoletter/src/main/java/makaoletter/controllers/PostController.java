package makaoletter.controllers;

import makaoletter.services.PostService;
import makaoletter.views.PageGenerator;
import makaoletter.views.PostPageGenerator;
import makaoletter.views.PostResultPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/post")
  public String post() {
    PageGenerator pageGenerator = new PostPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/post")
  public String registerPost(
      @RequestParam("title") String title,
      @RequestParam("author") String author,
      @RequestParam("content") String content
  ) {
    String status = postService.addNewPost(title, author, content);

    PageGenerator pageGenerator = new PostResultPageGenerator(status);
    return pageGenerator.html();
  }
}
