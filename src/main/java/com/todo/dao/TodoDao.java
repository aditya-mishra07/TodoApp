package com.todo.dao;

import com.todo.model.Todo;
import com.todo.utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TodoDao implements ITodoDao {
    @Override
    public List<Todo> selectALlTodos(int user_id) throws ClassNotFoundException {
        List<Todo> todos = new ArrayList<>();
        String SQL_QUERY = "SELECT * FROM todos WHERE user_id  = ?;";
        ResultSet result;
        try(Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
            preparedStatement.setString(1, Integer.toString(user_id));
            result = preparedStatement.executeQuery();
            while(result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                Date target_date = result.getDate("date");
                boolean is_done = result.getBoolean("completed");
                Todo todo = new Todo(id, title, description, is_done, user_id, target_date);
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public Todo createTodo(Todo todo, int user_id) {
        String SQL_QUERY = "INSERT INTO todos" + " (title, description, is_done target_date, user_id) ;";
        ResultSet result;
        try(Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
//          preparedStatement.setString("title", todo.getTitle());
//            preparedStatement.setString("description", todo.getDescription());
//            preparedStatement.setBoolean("is_done", todo.getIs_done());
            result = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Todo selectTodoById(int id) throws SQLException {
        return null;
    }

    @Override
    public Todo editTodo(int id) throws SQLException {
        return null;
    }

    @Override
    public Todo deleteTodo(int id) throws SQLException {
        return null;
    }

}
