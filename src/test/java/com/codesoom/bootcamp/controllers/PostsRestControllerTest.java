package com.codesoom.bootcamp.controllers;

import com.codesoom.bootcamp.domain.PostsSaveRequestDto;
import com.codesoom.bootcamp.service.PostsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostsRestController.class)
class PostsRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostsService postsService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void savePosts() throws Exception {
        mockMvc.perform(
                post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"author\":\"test author\"," +
                                "\"bootcampName\":\"test bootcamp\",\"content\":\"test content\"}")
        )
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        containsString("\"content\":\"test content\"")
                ))
                .andExpect(content().string(
                        containsString("\"author\":\"test author\"")
                ));
    }
}
