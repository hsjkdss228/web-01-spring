package todolist.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist.views.GreetingPageGenerator;
import todolist.views.PageGenerator;

@RestController
public class HomeController {
  @GetMapping("/")
  public String home() {
    PageGenerator pageGenerator = new GreetingPageGenerator();
    return pageGenerator.html();
  }
}
