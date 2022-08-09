package makaoletter.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostTest {
  @Test
  void creation() {
    Post post = new Post("글 제목", "글 저자명", "글 내용");

    assertThat(post.title()).isEqualTo("글 제목");
    assertThat(post.author()).isEqualTo("글 저자명");
    assertThat(post.content()).isEqualTo("글 내용");
  }
}
