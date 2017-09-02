package co.devhack.todoapp.presenter;

import java.util.List;

import co.devhack.todoapp.model.TodoItem;

import static co.devhack.todoapp.repository.Storage.TODO_ITEMS;

/**
 * Created by krlosf on 1/09/17.
 */

public class MainPresenter implements MainContract.ActionListener {
    public MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public List<TodoItem> getTodoList() {
        return TODO_ITEMS;
    }

    @Override
    public void addTodo(String description) {
        //Sedicionar el nuevo item a la lista
        TODO_ITEMS.add(new TodoItem(false, description));

        view.refreshTodoList();
    }

    @Override
    public void changeTodoStatus(int position, Boolean finished) {
        TODO_ITEMS.get(position).setFinished(finished);

        view.refreshTodoItem(position);
    }
}
