package com.example.demo.service;

import com.example.demo.model.Publisher;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.dto.PublisherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<PublisherDTO> getAllPublishers() {
        return publisherRepository.findAll().stream()
                .map(publisher -> {
                    PublisherDTO dto = new PublisherDTO();
                    dto.setId(publisher.getId());
                    dto.setName(publisher.getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public PublisherDTO getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        PublisherDTO dto = new PublisherDTO();
        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        return dto;
    }

    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDTO.getName());
        publisher = publisherRepository.save(publisher);
        publisherDTO.setId(publisher.getId());
        return publisherDTO;
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
