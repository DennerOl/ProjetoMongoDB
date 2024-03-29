package com.example.workshopmongo.services;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.models.dto.PostDTO;
import com.example.workshopmongo.models.entities.Post;
import com.example.workshopmongo.repositories.PostRepository;
import com.example.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

  @Autowired
  private PostRepository repository;

  public PostDTO findById(String id) {
    Optional<Post> result = repository.findById(id);
    Post entity = result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    return new PostDTO(entity);
  }

  public List<PostDTO> findByTitle(String text) {
    List<Post> list = repository.findByTitleContainingIgnoreCase(text);
    return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
  }

  public List<PostDTO> fullSearch(String text, String start, String end) {
    Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
    Instant endMoment = convertMoment(end, Instant.now());
    List<Post> list = repository.fullSearch(text, startMoment, endMoment);
    return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
  }

  private Instant convertMoment(String orignalText, Instant alternative) {
    try {
      return Instant.parse(orignalText);
    } catch (DateTimeParseException e) {
      return alternative;
    }
  }

}