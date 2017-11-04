package co.devhack.todoapp.presenter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.model.TodoItem;
import co.devhack.todoapp.repository.TodoRepository;
import co.devhack.todoapp.repository.impl.TodoRepositoryDb;
import co.devhack.todoapp.repository.impl.TodoRepositoryRest;

/**
 * Created by krlosf on 1/09/17.
 */

public class MainPresenter implements MainContract.ActionListener {
    private MainContract.View view;
    private TodoRepository todoRepository;
    private List<TodoItem> lstTodoList;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.lstTodoList = new ArrayList<>(0);
        this.todoRepository = new TodoRepositoryRest();
    }

    @Override
    public void loadTodoList() {
        try {
            todoRepository.getAll(new Callback() {
                @Override
                public void finish(Throwable error, Object result) {
                    lstTodoList.clear();
                    if(error != null) {
                        view.showErrorMessage();
                    } else {
                        lstTodoList.addAll((List<TodoItem>) result);
                    }

                    view.refreshTodoList();
                }
            });
        } catch (SQLException e) {
            view.showErrorMessage();
        }
    }

    @Override
    public List<TodoItem> getTodoList() {
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
