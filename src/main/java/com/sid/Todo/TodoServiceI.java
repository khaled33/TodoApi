package com.sid.Todo;

import java.util.List;

public interface TodoServiceI {
    List<Todo>getAllTodo();
    Todo getByIdTodo(Long id);
    Todo AddTodo(Todo todo);
    Todo ModifeTodo(Todo todo);
    void DeleteTodo(Long id);
    void changerStatus(String Status,Long id);
    public DtoStatsc stat();
}
