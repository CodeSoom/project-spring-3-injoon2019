package com.codesoom.bootcamp.controllers;

import com.codesoom.bootcamp.domain.PostsSaveRequestDto;
import com.codesoom.bootcamp.service.PostsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostsRestController {

    private final PostsService postsService;

    public PostsRestController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
