package com.example.workshopmongo.models.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.example.workshopmongo.models.agregados.Author;
import com.example.workshopmongo.models.agregados.Comment;
import com.example.workshopmongo.models.entities.Post;

public class PostDTO {

  private String id;
  private Instant moment;
  private String title;
  private String body;
  private Author author;

  private List<Comment> comments = new ArrayList<>();

  public PostDTO() {
  }

  public PostDTO(String id, Instant moment, String title, String body, Author author, List<Comment> comments) {
    this.id = id;
    this.moment = moment;
    this.title = title;
    this.body = body;
    this.author = author;

  }

  public PostDTO(Post entity) {

    ModelMapper modelMapper = new ModelMapper();
    modelMapper.map(entity, this);
    this.comments.addAll(entity.getComments());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public List<Comment> getComments() {
    return comments;
  }

}
