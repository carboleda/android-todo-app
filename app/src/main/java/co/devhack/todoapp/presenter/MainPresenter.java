package co.devhack.todoapp.presenter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.devhack.todoapp.model.TodoItem;
import co.devhack.todoapp.repository.TodoRepository;

/**
 * Created by krlosf on 1/09/17.
 */

public class MainPresenter implements MainContract.ActionListener {
    private MainContract.View view;
    private TodoRepository todoRepository;
    private List<TodoItem> lstTodoList = new ArrayList<>(0);

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.todoRepository = new TodoRepository();
    }

    @Override
    public List<TodoItem> getTodoList() {
        try {
            lstTodoList.clear();
            lstTodoList.addAll(todoRepository.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lstTodoList;
    }

    @Override
    public void addTodo(String description) {
        try {
            todoRepository.create(new TodoItem(false, description));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        view.refreshTodoList();
    }

    @Override
    public void changeTodoStatus(int position, Boolean finished) {
        try {
            TodoItem todoItem = lstTodoList.get(position);
            todoItem.setFinished(finished);
            todoRepository.update(todoItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        view.refreshTodoItem(position);
    }
}
