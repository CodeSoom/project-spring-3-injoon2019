package com.codesoom.bootcamp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String bootcampName;

    @Column
    private String content;

    private String author;

    @Builder
    public Posts(String bootcampName, String content, String author) {
        this.bootcampName = bootcampName;
        this.content = content;
        this.author = author;
    }
}
