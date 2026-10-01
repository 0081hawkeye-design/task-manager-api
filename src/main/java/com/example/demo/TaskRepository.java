package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// empty on purpose! JpaRepository already gives us save, findAll, findById, deleteById...
// <Task, Integer> = "works with Task objects, whose id is an Integer"
public interface TaskRepository extends JpaRepository<Task, Integer> {
}