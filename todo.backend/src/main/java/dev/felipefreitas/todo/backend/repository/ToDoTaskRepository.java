package dev.felipefreitas.todo.backend.repository;

import dev.felipefreitas.todo.backend.model.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Long> { }
