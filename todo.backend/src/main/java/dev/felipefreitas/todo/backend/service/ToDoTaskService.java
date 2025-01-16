package dev.felipefreitas.todo.backend.service;

import dev.felipefreitas.todo.backend.model.ToDoTask;
import dev.felipefreitas.todo.backend.repository.ToDoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoTaskService {

    private final ToDoTaskRepository toDoTaskRepository;

    @Autowired
    public ToDoTaskService(ToDoTaskRepository toDoTaskRepository) {
        this.toDoTaskRepository = toDoTaskRepository;
    }

    public List<ToDoTask> findAllToDoTasks() {
        return toDoTaskRepository.findAll();
    }

    public ToDoTask findToDoTaskById(Long id) {
        return toDoTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("To-do task not found with id: " + id));
    }

    public ToDoTask saveToDoTask(ToDoTask toDoTask) {
        return toDoTaskRepository.save(toDoTask);
    }

    public ToDoTask updateToDoTask(Long id, ToDoTask toDoTask) {
        ToDoTask existingTask = findToDoTaskById(id);
        existingTask.setDescription(toDoTask.getDescription());
        existingTask.setCompleted(toDoTask.getCompleted());
        return toDoTaskRepository.save(existingTask);
    }

    public void deleteToDoTask(Long id) {
        toDoTaskRepository.deleteById(id);
    }
}
