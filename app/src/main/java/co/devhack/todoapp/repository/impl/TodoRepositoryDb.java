package co.devhack.todoapp.repository.impl;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.helpers.DatabaseHelper;
import co.devhack.todoapp.model.TodoItem;
import co.devhack.todoapp.repository.TodoRepository;

/**
 * Created by krlosf on 28/08/17.
 */

public class TodoRepositoryDb implements TodoRepository {
    @Override
    public int create(TodoItem todoItem) throws SQLException {
        Dao todoItemDao = DatabaseHelper.getInstance().getDao();
        return todoItemDao.create(todoItem);
    }

    @Override
    public int update(TodoItem todoItem) throws SQLException {
        Dao todoItemDao = DatabaseHelper.getInstance().getDao();
        return todoItemDao.update(todoItem);
    }

    @Override
    public List<TodoItem> getAll() throws SQLException {
        Dao todoItemDao = DatabaseHelper.getInstance().getDao();
        return (List<TodoItem>) todoItemDao.queryForAll();
    }

    @Override
    public void getAll(Callback callback) throws SQLException {

    }
}
