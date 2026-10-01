package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // this class = a table in the database
public class Task {

    @Id // this field is the unique key of each row
    @GeneratedValue(strategy = GenerationType.IDENTITY) // database creates the id (1, 2, 3...) for us
    private int id;

    @NotBlank(message = "Title cannot be empty") // rejects null, "" and "   "
    private String title;
    private boolean done;

    public Task() { }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}