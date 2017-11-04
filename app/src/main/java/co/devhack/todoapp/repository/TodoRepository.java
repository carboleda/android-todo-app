package co.devhack.todoapp.repository;

import java.sql.SQLException;
import java.util.List;

import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.model.TodoItem;

/**
 * Created by krlosf on 28/08/17.
 */

public interface TodoRepository {

    int create(TodoItem todoItem) throws SQLException;

    int update(TodoItem todoItem) throws SQLException;

    List<TodoItem> getAll() throws SQLException;

    void getAll(Callback callback) throws SQLException;
}
