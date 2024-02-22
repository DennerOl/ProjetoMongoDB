package com.example.workshopmongo.models.agregados;

import com.example.workshopmongo.models.entities.User;

// classe serve como agregados pois são classes auxiliares

public class Author {

  private String id;
  private String name;

  public Author() {
  }

  public Author(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Author(User entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
