package makaoletter.services;

import makaoletter.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostServiceTest {
  private PostRepository postRepository;
  private PostService postService;

  @BeforeEach
  void initialization() {
    postRepository = new PostRepository();
    postService = new PostService(postRepository);
  }

  @Test
  void addNewPostAndAccepted() {
    String status = postService.addNewPost("제목 123", "작성자 123", "글 내용 123");

    assertThat(status).isEqualTo(PostService.ACCEPTED);
  }

  @Test
  void addNewPostButWithoutTitle() {
    String status = postService.addNewPost("", "작성자 123", "글 내용 123");

    assertThat(status).isEqualTo(PostService.INSUFFICIENT);
  }

  @Test
  void addNewPostButWithoutAuthor() {
    String status = postService.addNewPost("제목 123", "", "글 내용 123");

    assertThat(status).isEqualTo(PostService.INSUFFICIENT);
  }

  @Test
  void addNewPostButWithoutContent() {
    String status = postService.addNewPost("제목 123", "작성자 123", "");

    assertThat(status).isEqualTo(PostService.INSUFFICIENT);
  }
}
