package com.todo.model;

import java.util.Date;

public class Todo {
    private int id;
    private String title;
    private String description;
    private boolean is_done;
    private int user_id;
    private Date target_date;

    public Todo(String title, String description, boolean is_done, int user_id
    , Date target_date) {
        this.title = title;
        this.description = description;
        this.is_done = is_done;
        this.user_id = user_id;
        this.target_date = target_date;
    }
    public Todo(int id, String title, String description, boolean is_done, int user_id
            , Date target_date) {
        this.id = this.id;
        this.title = title;
        this.description = description;
        this.is_done = is_done;
        this.user_id = user_id;
        this.target_date = target_date;

    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public boolean getIs_done() {
        return is_done;
    }
    public int getUser_id() {
        return user_id;
    }
    public Date getTarget_date() {
        return target_date;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setTarget_date(Date target_date) {
        this.target_date = target_date;
    }
}
