package com.codesoom.bootcamp.service;

import com.codesoom.bootcamp.domain.PostsRepository;
import com.codesoom.bootcamp.domain.PostsSaveRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository
                .save(requestDto.toEntity())
                .getId();
    }
}
