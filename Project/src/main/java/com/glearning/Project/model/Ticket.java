package com.glearning.Project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;

	private String description;

	private String content;

	private LocalDate date;

	public Ticket() {
		super();
	}

	public Ticket(String title, String description, String content, LocalDate date) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	/*
	 * This method sets the ticket creation date to the system date when a new
	 * ticket is created (before it is persisted in the DB)
	 */
	@PrePersist
	public void prePersist() {
		date = LocalDate.now();
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", \ntitle=" + title + ", \ndescription=" + description + ", \ncontent=" + content
				+ ", \ndate=" + date + "]";
	}

}
