package makaoletter.controllers;

import makaoletter.repositories.PostRepository;
import makaoletter.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private PostRepository postRepository;

  @SpyBean
  private PostService postService;

  @Test
  void post() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/post"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("등록하기")
        ));
  }
}
