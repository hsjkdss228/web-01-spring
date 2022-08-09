package makaoletter.views;

import makaoletter.repositories.PostRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PostsPageGenerator extends PageGenerator {
  private final Map<String, List<String>> titleAndAuthors;

  public PostsPageGenerator(Map<String, List<String>> titleAndAuthors) {
    super();
    this.titleAndAuthors = titleAndAuthors;
  }

  @Override
  public String content() {
    return "<form method=\"POST\">\n" +
        "<p>\n" +
        "<label>저자: \n" +
        "<input type=\"text\" name=\"author\" />\n" +
        "</label>\n" +
        "<button type=\"submit\">찾기</button>\n" +
        "</p>\n" +
        "</nav>\n" +
        showTitles();
  }

  public String showTitles() {
    return "<ul>\n" +
        titleAndAuthors.values().stream()
            .map(titleAndAuthor ->
                "<li>" + titleAndAuthor.get(PostRepository.TITLE_INDEX) +
                    " <small>by." + titleAndAuthor.get(PostRepository.AUTHOR_INDEX) + "</small>" +
                    "</li>\n")
            .collect(Collectors.joining()) +
        "</ul>\n";
  }
}
