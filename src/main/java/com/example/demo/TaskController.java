package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:5173") // allow our React app to call this API
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Task add(@Valid @RequestBody Task task) { // @Valid = check the rules from Task.java
        return service.add(task);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable int id, @Valid @RequestBody Task task) {
        Task updated = service.update(id, task);
        if (updated == null) { // service found nothing
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"); // send a 404
        }
        return updated;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        if (!service.delete(id)) { // nothing was deleted
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"); // send a 404
        }
        return "Deleted";
    }
}