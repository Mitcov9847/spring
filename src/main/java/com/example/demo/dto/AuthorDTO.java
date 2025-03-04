package com.example.demo.dto;

import com.example.demo.model.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorDTO {
    private Long id;
    private String name;

    public static AuthorDTO fromEntity(Author author) {
        return new AuthorDTO(author.getId(), author.getName());
    }
}

