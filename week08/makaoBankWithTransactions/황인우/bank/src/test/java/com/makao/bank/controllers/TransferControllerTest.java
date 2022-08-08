package com.makao.bank.controllers;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import com.makao.bank.services.AccountService;
import com.makao.bank.services.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransferController.class)
class TransferControllerTest {
  private static final String RECEIVER_IDENTIFIER = "179";
  private static final long INITIAL_AMOUNT = 1000;

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private AccountRepository accountRepository;

  @SpyBean
  private AccountService accountService;

  @SpyBean
  private TransferService transferService;

  @BeforeEach
  void initialize() {
    accountRepository.reset();
  }

  @Test
  void transferGet() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/transfer"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("받는 사람 계좌: ")
        ));
  }

  @Test
  void transfer300() throws Exception {
    long transferAmount = 300;

    mockMvc.perform(
        MockMvcRequestBuilders.post("/transfer")
            .param("to", TransferControllerTest.RECEIVER_IDENTIFIER)
            .param("amount", Long.toString(transferAmount)))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));

    Account myAccount = accountService.myAccount();
    assertThat(myAccount.amount()).isEqualTo(
        TransferControllerTest.INITIAL_AMOUNT - transferAmount);
  }

  @Test
  void transfer500() throws Exception {
    long transferAmount = 500;

    mockMvc.perform(
            MockMvcRequestBuilders.post("/transfer")
                .param("to", TransferControllerTest.RECEIVER_IDENTIFIER)
                .param("amount", Long.toString(transferAmount)))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));

    Account myAccount = accountService.myAccount();
    assertThat(myAccount.amount()).isEqualTo(
        TransferControllerTest.INITIAL_AMOUNT - transferAmount);
  }

  @Test
  void transferWithoutTo() throws Exception {
    long transferAmount = 200;

    mockMvc.perform(
            MockMvcRequestBuilders.post("/transfer")
                .param("to", "")
                .param("amount", Long.toString(transferAmount)))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("입력하지 않은 내용이 있습니다.")
        ));
  }

  @Test
  void transferWithoutAmount() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.post("/transfer")
                .param("to", TransferControllerTest.RECEIVER_IDENTIFIER)
                .param("amount", ""))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("입력하지 않은 내용이 있습니다.")
        ));
  }

  @Test
  void transferWithInvalidAmount() throws Exception {
    long transferAmount = -50000000;

    mockMvc.perform(
            MockMvcRequestBuilders.post("/transfer")
                .param("to", TransferControllerTest.RECEIVER_IDENTIFIER)
                .param("amount", Long.toString(transferAmount)))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("보낼 금액을 확인해 주세요.")
        ));
  }

  @Test
  void transferWithInvalidIdentifier() throws Exception {
    long transferAmount = 300;

    mockMvc.perform(
            MockMvcRequestBuilders.post("/transfer")
                .param("to", "444444")
                .param("amount", Long.toString(transferAmount)))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 번호를 확인해 주세요.")
        ));
  }
}
