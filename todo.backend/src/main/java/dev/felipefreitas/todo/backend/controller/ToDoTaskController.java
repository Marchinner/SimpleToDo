package dev.felipefreitas.todo.backend.controller;

import dev.felipefreitas.todo.backend.model.ToDoTask;
import dev.felipefreitas.todo.backend.service.ToDoTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class ToDoTaskController {

    private final ToDoTaskService toDoTaskService;

    @Autowired
    public ToDoTaskController(ToDoTaskService toDoTaskService) {
        this.toDoTaskService = toDoTaskService;
    }

    @GetMapping
    public ResponseEntity<List<ToDoTask>> getAllTasks() {
        List<ToDoTask> tasks = toDoTaskService.findAllToDoTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoTask> getTaskById(@PathVariable Long id) {
        ToDoTask task = toDoTaskService.findToDoTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<ToDoTask> createTask(@RequestBody ToDoTask toDoTask) {
        ToDoTask createdTask = toDoTaskService.saveToDoTask(toDoTask);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoTask> updateTask(@PathVariable Long id, @RequestBody ToDoTask toDoTask) {
        ToDoTask updatedTask = toDoTaskService.updateToDoTask(id, toDoTask);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        toDoTaskService.deleteToDoTask(id);
        return ResponseEntity.noContent().build();
    }
}
