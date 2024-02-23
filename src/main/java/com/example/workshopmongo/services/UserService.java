package com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.workshopmongo.models.dto.UserDTO;
import com.example.workshopmongo.models.entities.User;
import com.example.workshopmongo.repositories.UserRepository;
import com.example.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<UserDTO> findAll() {
    List<User> list = repository.findAll();
    return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
  }

  public UserDTO findById(String id) {
    Optional<User> result = repository.findById(id);
    User entity = result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    return new UserDTO(entity);
  }

  public UserDTO insert(UserDTO dto) {
    User entity = new User();
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(dto, entity);
    entity = repository.insert(entity);
    return new UserDTO(entity);
  }

  private User getEntityById(String id) {
    Optional<User> result = repository.findById(id);
    return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
  }

  public UserDTO update(String id, UserDTO dto) {

    User entity = getEntityById(id);
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(dto, entity);
    entity = repository.save(entity);
    return new UserDTO(entity);
  }

}
