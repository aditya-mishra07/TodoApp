package com.todo.dao;

import com.todo.model.User;

public interface IUserDao {
    User register(User user) throws ClassNotFoundException;
    User login(User user) throws ClassNotFoundException;
}
