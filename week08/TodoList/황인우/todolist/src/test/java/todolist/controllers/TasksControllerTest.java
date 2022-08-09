package todolist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import todolist.repositories.TaskRepository;
import todolist.services.TaskService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TasksController.class)
class TasksControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private TaskRepository taskRepository;

  @SpyBean
  private TaskService taskService;

  @Test
  void tasksPage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("")
        ));
  }

  @Test
  void addSomeTasksCase1() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
            .param("task", "새로운 할 일 1"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("새로운 할 일 1")
        ));

    mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
            .param("task", "새로운 할 일 2"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("새로운 할 일 1")
        ))
        .andExpect(content().string(
            containsString("새로운 할 일 2")
        ));

    mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
            .param("task", "새로운 할 일 3"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("새로운 할 일 1")
        ))
        .andExpect(content().string(
            containsString("새로운 할 일 2")
        ))
        .andExpect(content().string(
            containsString("새로운 할 일 3")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("새로운 할 일 1")
        ))
        .andExpect(content().string(
            containsString("새로운 할 일 2")
        ))
        .andExpect(content().string(
            containsString("새로운 할 일 3")
        ));
  }
}
