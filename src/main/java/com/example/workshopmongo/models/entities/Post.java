package com.example.workshopmongo.models.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.workshopmongo.models.agregados.Author;
import com.example.workshopmongo.models.agregados.Comment;

@Document(collection = "posts")
public class Post {

	@Id
	private String id;
	private Instant moment;
	private String title;
	private String body;
	// um post tem um author
	private Author author;
	// um post pode ter varios comentarios
	private List<Comment> comments = new ArrayList<>();

	public Post() {
	}

	public Post(String id, Instant moment, String title, String body, Author author) {
		super();
		this.id = id;
		this.moment = moment;
		this.title = title;
		this.body = body;
		this.author = author;
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

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
