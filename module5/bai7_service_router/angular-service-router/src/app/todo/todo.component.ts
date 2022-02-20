import { Component, OnInit } from '@angular/core';
import {ITodo} from "../ITodo";
import {FormControl} from "@angular/forms";
import {TodoService} from "../todo.service";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todoList: ITodo[] = [];
  inputControl = new FormControl();
  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.todoService.getTodo().subscribe(next => {
      this.todoList = next;
    }, error => {
      console.log(error);
    }, ()=>{
      console.log('complete');
    });
  }

  toggleTodo(i){
    const todo = this.todoList[i];
    const todoData = {
      ...todo,
      completed: !todo.completed,
    };
    this.todoService.updateTodo(todoData).subscribe(next => {
      this.todoList[i].completed
    })
  }

  addTodo(){
    const todo: Partial<ITodo> = {
      title: this.inputControl.value,
      completed: false,
    };
  }

}
