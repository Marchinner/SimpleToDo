import { Component, OnInit } from '@angular/core';
import { Todo } from './todo.model';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-todo',
  standalone: false,
  
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.scss'
})
export class TodoComponent implements OnInit {

  tasks: Todo[] = [];
  newTaskDescription: string = '';

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.todoService.getTasks().subscribe((data) => {
      this.tasks = data;
    });
  }

  addTask(): void {
    if (this.newTaskDescription.trim()) {
      const newTask: Partial<Todo> = {
        description: this.newTaskDescription,
        completed: false
      };

      this.todoService.addTask(newTask).subscribe((todo) => {
        this.tasks.push(todo);
        this.newTaskDescription = '';
      });
    }
  }
}
