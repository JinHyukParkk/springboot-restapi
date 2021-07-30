package com.example.demo.configs;

import com.example.demo.accounts.AccountService;
import com.example.demo.common.AppProperties;
import com.example.demo.common.BaseTest;
import com.example.demo.common.TestDescription;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthServerConfigTest extends BaseTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AppProperties appProperties;

    @Test
    @TestDescription("인증 토큰을 발급 받는 테스트")
    public void getAuthToken() throws Exception {
        // Given
        String username = appProperties.getUserUsername();
        String password = appProperties.getUserPassword();

       this.mockMvc.perform(post("/oauth/token")
               .with(httpBasic(appProperties.getClientId(), appProperties.getClientSecret()))
               .param("username", username)
               .param("password", password)
               .param("grant_type", "password")
       )
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("access_token").exists());
    }
}