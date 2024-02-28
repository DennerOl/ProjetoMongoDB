package com.example.workshopmongo.services;

import java.util.Optional;

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
  /*
   * 
   * private Post getEntityById(String id) {
   * Optional<Post> result = repository.findById(id);
   * return result.orElseThrow(() -> new
   * ResourceNotFoundException("Objeto não encontrado"));
   * }
   */
}
