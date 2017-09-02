package co.devhack.todoapp.repository;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import co.devhack.todoapp.DatabaseHelper;
import co.devhack.todoapp.model.TodoItem;

/**
 * Created by krlosf on 28/08/17.
 */

public class TodoRepository {
    public int create(TodoItem todoItem) throws SQLException {
        Dao todoItemDao = DatabaseHelper.getInstance().getDao();
        return todoItemDao.create(todoItem);
    }

    public int update(TodoItem todoItem) throws SQLException {
        Dao todoItemDao = DatabaseHelper.getInstance().getDao();
        return todoItemDao.update(todoItem);
    }

    public List<TodoItem> getAll() throws SQLException {
        Dao todoItemDao = DatabaseHelper.getInstance().getDao();
        return (List<TodoItem>) todoItemDao.queryForAll();
    }
}
