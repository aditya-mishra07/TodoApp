package com.todo.dao;

import com.todo.model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface ITodoDao {
    List<Todo> selectALlTodos(int user_id) throws ClassNotFoundException;
    Todo selectTodoById(int id) throws SQLException;
    Todo deleteTodo(int id)throws SQLException;
    Todo editTodo(int id) throws SQLException;
    Todo createTodo(Todo todo, int user_id);

}
