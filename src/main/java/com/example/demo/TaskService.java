package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repo; // the database helper

    // dependency injection again: Spring hands us the repository
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll(); // SELECT * FROM task
    }

    public Task add(Task task) {
        return repo.save(task); // INSERT, and the DB gives it an id
    }

    public Task update(int id, Task newData) {
        Task t = repo.findById(id).orElse(null); // look up by id, null if not found
        if (t == null) return null;
        t.setTitle(newData.getTitle());
        t.setDone(newData.isDone());
        return repo.save(t); // UPDATE
    }

    public boolean delete(int id) {
        if (!repo.existsById(id)) return false; // nothing to delete
        repo.deleteById(id);                    // DELETE
        return true;
    }
}