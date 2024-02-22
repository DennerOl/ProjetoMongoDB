package com.example.workshopmongo.models.agregados;

import java.time.Instant;

public class Comment {

  private String text;
  private Instant moment;
  // um comentario tem um author
  private Author author;

  public Comment() {
  }

  public Comment(String text, Instant moment, Author author) {
    this.text = text;
    this.moment = moment;
    this.author = author;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
