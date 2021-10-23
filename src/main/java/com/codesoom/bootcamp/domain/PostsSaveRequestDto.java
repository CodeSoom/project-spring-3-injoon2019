package com.codesoom.bootcamp.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsSaveRequestDto {
    private String author;
    private String content;
    private String bootcampName;

    @Builder
    public PostsSaveRequestDto(String author, String content, String bootcampName) {
        this.author = author;
        this.content = content;
        this.bootcampName = bootcampName;
    }

    public Posts toEntity() {
        return Posts.builder()
                .author(author)
                .content(content)
                .bootcampName(bootcampName)
                .build();
    }
}
