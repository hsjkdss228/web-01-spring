package makaoletter.repositories;

import makaoletter.models.Post;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PostRepositoryTest {
  @Test
  void addNewPost() {
    PostRepository postRepository = new PostRepository();

    postRepository.addNewPost("제목 1", "작성자 1", "내용 1");
    postRepository.addNewPost("제목 2", "작성자 2", "내용 2");
    postRepository.addNewPost("제목 3", "작성자 3", "내용 3");
    postRepository.addNewPost("제목 444444", "작성자 1", "내용 4444444444");

    Map<String, List<Post>> posts = postRepository.posts();
    Map<String, List<String>> titleAndAuthors = postRepository.titleAndAuthors();

    assertThat(posts.size()).isEqualTo(3);
    assertThat(titleAndAuthors.size()).isEqualTo(4);

    List<Post> postsWrittenByAuthor1 = posts.get("작성자 1");

    assertThat(postsWrittenByAuthor1.size()).isEqualTo(2);

    Post secondaryPost = postsWrittenByAuthor1.get(1);
    assertThat(secondaryPost.title())
        .isEqualTo(titleAndAuthors.get(secondaryPost.identifier())
            .get(PostRepository.TITLE_INDEX));
    assertThat(secondaryPost.author())
        .isEqualTo(titleAndAuthors.get(secondaryPost.identifier())
            .get(PostRepository.AUTHOR_INDEX));
  }
}
