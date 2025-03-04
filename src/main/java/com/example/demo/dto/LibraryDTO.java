package com.example.demo.dto;

import com.example.demo.model.Library;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LibraryDTO {
    private Long id;
    private String name;
    private List<Long> bookIds;

    public static LibraryDTO fromEntity(Library library) {
        return new LibraryDTO(library.getId(), library.getName(), library.getBookIds());
    }

    public static Library toEntity(LibraryDTO dto) {
        return new Library(dto.getId(), dto.getName(), dto.getBookIds());
    }
}

