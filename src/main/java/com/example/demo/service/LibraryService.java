package com.example.demo.service;

import com.example.demo.dto.LibraryDTO;
import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public List<LibraryDTO> getAllLibraries() {
        return libraryRepository.findAll()
                .stream()
                .map(LibraryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public LibraryDTO getLibraryById(Long id) {
        return libraryRepository.findById(id)
                .map(LibraryDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Library not found"));
    }

    public LibraryDTO createLibrary(LibraryDTO libraryDTO) {
        Library library = LibraryDTO.toEntity(libraryDTO);
        Library savedLibrary = libraryRepository.save(library);
        return LibraryDTO.fromEntity(savedLibrary);
    }

    public LibraryDTO updateLibrary(Long id, LibraryDTO libraryDTO) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));

        library.setName(libraryDTO.getName());
        library.setBookIds(libraryDTO.getBookIds());

        Library updatedLibrary = libraryRepository.save(library);
        return LibraryDTO.fromEntity(updatedLibrary);
    }

    public void deleteLibrary(Long id) {
        libraryRepository.deleteById(id);
    }
}
