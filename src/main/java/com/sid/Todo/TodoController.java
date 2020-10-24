package com.sid.Todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
    final TodoServiceI todoServiceI;

     public TodoController(TodoServiceI todoServiceI) {
        this.todoServiceI = todoServiceI;
    }

    @GetMapping("/Todos")
    public List<Todo> getAllTodo() {
        return todoServiceI.getAllTodo();
    }
    @GetMapping("/Todo/{id}")
    public Todo getByIdTodo(@PathVariable Long id) {
        return todoServiceI.getByIdTodo(id);
    }
    @PostMapping("/Todo")
    public Todo AddTodo(@RequestBody Todo todo) {
        return todoServiceI.AddTodo(todo);
    }
    @PutMapping("/Todo")
    public Todo ModifeTodo(@RequestBody Todo todo) {
        return todoServiceI.ModifeTodo(todo);
    }
    @DeleteMapping("/Todo/{id}")
    public void DeleteTodo(@PathVariable Long id) {
        todoServiceI.DeleteTodo(id);
    }
    @GetMapping("/Todo/{id}/Status/{Status}")
    public void changerStatus(@PathVariable String Status,@PathVariable Long id) {
        todoServiceI.changerStatus(Status, id);
    }
    @GetMapping("/Todo/Stat")
    public DtoStatsc stat() {
        return todoServiceI.stat();
    }
}
