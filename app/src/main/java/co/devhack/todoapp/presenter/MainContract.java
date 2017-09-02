package co.devhack.todoapp.presenter;

import java.util.List;

import co.devhack.todoapp.model.TodoItem;

/**
 * Created by krlosf on 1/09/17.
 */

public class MainContract {
    public interface View {
        void refreshTodoList();

        void refreshTodoItem(int position);
    }

    public interface ActionListener {
        List<TodoItem> getTodoList();

        void addTodo(String description);

        void changeTodoStatus(int position, Boolean finished);
    }
}
