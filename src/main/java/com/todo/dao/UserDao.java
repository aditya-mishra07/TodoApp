package com.todo.dao;
import com.todo.model.User;
import com.todo.utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IUserDao {

    public User register(User user) throws ClassNotFoundException {
        String SQL_QUERY = "INSERT INTO users" + " (email, password) VALUES (?,?);";
        ResultSet result ;
        try(Connection connection = JDBC.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            result = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User login(User user) throws ClassNotFoundException {
        String SQL_QUERY = "SELECT * FROM users WHERE email = ? AND password = ?";
        ResultSet result;
        try(Connection connection = JDBC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)){
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            result = preparedStatement.executeQuery();
            if(result.next()) {
                String storedPassword = result.getString("password");
                String storedEmail = result.getString("email");
                if(storedPassword.equals(user.getPassword()) && storedEmail.equals(user.getEmail())) {
                    return user;
                }
            } else {
                return null;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
